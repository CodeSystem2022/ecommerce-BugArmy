package com.chimy.ecommerceapp.fragments.loginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chimy.ecommerceapp.R
import com.chimy.ecommerceapp.databinding.FragmentAccountOptionsBinding
import com.chimy.ecommerceapp.databinding.FragmentIntroductionBinding

class AccountOptionsFragment: Fragment(R.layout.fragment_account_options) {
    private lateinit var binding: FragmentAccountOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountOptionsBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButtomAccountOptions.setOnClickListener{
            findNavController().navigate(R.id.action_accountOptionsFragment2_to_loginFragment)
        }
        binding.registerButtomAccountOptions.setOnClickListener{
            findNavController().navigate(R.id.action_accountOptionsFragment2_to_registerFragment)
        }
    }

}