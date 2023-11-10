package com.chimy.ecommerceapp.fragments.loginRegister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.chimy.ecommerceapp.R
import com.chimy.ecommerceapp.activities.ShoppingActivity
import com.chimy.ecommerceapp.databinding.FragmentLoginBinding
import com.chimy.ecommerceapp.databinding.FragmentRegisterBinding
import com.chimy.ecommerceapp.dialog.setupBottomDialog
import com.chimy.ecommerceapp.util.Resource
import com.chimy.ecommerceapp.viewmodel.LoginViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRegisterNow.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.apply {
            buttomLoginLogin.setOnClickListener {
                val email = idEmailLogin.text.toString().trim()
                val password = idPasswordLogin.text.toString()
                viewModel.login(email, password)
            }
        }

        binding.tvForgotPassword.setOnClickListener{
            setupBottomDialog { email ->
                viewModel.resetPassword(email)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.resetPassword.collect{
                when (it) {
                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        Snackbar.make(requireView(),"Reset link was send to your email", Snackbar.LENGTH_LONG).show()
                    }

                    is Resource.Error -> {
                        Snackbar.make(requireView(),"Error: ${it.message}", Snackbar.LENGTH_LONG).show()
                    }

                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.login.collect {
                when (it) {
                    is Resource.Loading -> {
                        binding.buttomLoginLogin.startAnimation()
                    }

                    is Resource.Success -> {
                        binding.buttomLoginLogin.revertAnimation()
                        Intent(requireActivity(), ShoppingActivity::class.java).also { intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                    }

                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                        binding.buttomLoginLogin.revertAnimation()
                    }

                    else -> Unit
                }

            }
        }
    }
}