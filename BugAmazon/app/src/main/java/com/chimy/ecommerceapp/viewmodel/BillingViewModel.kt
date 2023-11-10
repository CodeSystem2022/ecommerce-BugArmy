package com.chimy.ecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimy.ecommerceapp.data.Adress
import com.chimy.ecommerceapp.util.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BillingViewModel @Inject constructor(

    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth

) : ViewModel() {

    private val _address = MutableStateFlow<Resource<List<Adress>>>(Resource.Unspecified())
    val address = _address.asStateFlow()

    init {
        getUserAddress()
    }

    fun getUserAddress() {
        viewModelScope.launch { _address.emit(Resource.Loading()) }
        firestore.collection("user").document(auth.uid!!).collection("adress")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    viewModelScope.launch { _address.emit(Resource.Error(error.message.toString())) }
                    return@addSnapshotListener
                }
                val addresses = value?.toObjects(Adress::class.java)
                viewModelScope.launch { _address.emit(Resource.Success(addresses!!)) }
            }

    }

}

