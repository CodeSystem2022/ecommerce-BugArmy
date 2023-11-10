package com.chimy.ecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimy.ecommerceapp.data.Category
import com.chimy.ecommerceapp.data.Product
import com.chimy.ecommerceapp.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoryViewModel constructor(
    private val firestore: FirebaseFirestore, private val category: Category
) : ViewModel() {

    private val _offerProduct = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val offerProduct = _offerProduct.asStateFlow()

    private val _bestProducts = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val bestProducts = _bestProducts.asStateFlow()

    init {
        fetchBestProducts()
        fetchOfferProducts()
    }

    fun fetchOfferProducts() {
        viewModelScope.launch {
            _offerProduct.emit(Resource.Loading())
        }
        firestore.collection("Products").whereEqualTo("category", category.category)
            .whereNotEqualTo("offerPercentage", null).get().addOnSuccessListener {
                val products = it.toObjects(Product::class.java)
                viewModelScope.launch {
                    _offerProduct.emit(Resource.Success(products))
                }
            }.addOnFailureListener {
                viewModelScope.launch {
                    _offerProduct.emit(Resource.Error(it.message.toString()))
                }
            }
    }

    fun fetchBestProducts() {
        viewModelScope.launch {
            _bestProducts.emit(Resource.Loading())
        }
        firestore.collection("Products").whereEqualTo("category", category.category)
            .whereEqualTo("offerPercentage", null).get().addOnSuccessListener {
                val products = it.toObjects(Product::class.java)
                viewModelScope.launch {
                    _bestProducts.emit(Resource.Success(products))
                }
            }.addOnFailureListener {
                viewModelScope.launch {
                    _offerProduct.emit(Resource.Error(it.message.toString()))
                }
            }

    }
}