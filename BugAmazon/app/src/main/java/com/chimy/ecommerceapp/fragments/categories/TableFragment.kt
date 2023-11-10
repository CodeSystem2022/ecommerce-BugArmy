package com.chimy.ecommerceapp.fragments.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.chimy.ecommerceapp.data.Category
import com.chimy.ecommerceapp.util.Resource
import com.chimy.ecommerceapp.viewmodel.CategoryViewModel
import com.chimy.ecommerceapp.viewmodel.factory.BaseCategoryViewModelFactory
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class TableFragment: BaseCategoryFragment() {


    @Inject
    lateinit var firestore: FirebaseFirestore


    val viewModel by viewModels<CategoryViewModel>{
        BaseCategoryViewModelFactory(firestore, Category.Table)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.offerProduct.collectLatest {
                when(it){
                    is Resource.Loading -> {
                        showOfferLoading()
                    }
                    is Resource.Success -> {
                        offerAdapter.differ.submitList(it.data)
                        hideOfferLoading()
                    }
                    is Resource.Error -> {
                        Snackbar.make(requireView(),it.message.toString(), Snackbar.LENGTH_LONG)
                            .show()
                        hideOfferLoading()
                    }
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.bestProducts.collectLatest {
                when(it){
                    is Resource.Loading -> {
                        showBestProductsLoading()
                    }
                    is Resource.Success -> {
                        bestProductAdapter.differ.submitList(it.data)
                        hideBestProductsLoading()
                    }
                    is Resource.Error -> {
                        Snackbar.make(requireView(),it.message.toString(), Snackbar.LENGTH_LONG)
                            .show()
                        hideBestProductsLoading()
                    }
                    else -> Unit
                }
            }
        }

    }
}