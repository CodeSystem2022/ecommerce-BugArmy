package com.chimy.ecommerceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimy.ecommerceapp.data.Adress
import com.chimy.ecommerceapp.util.Resource
import com.chimy.ecommerceapp.util.validateEmail
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdressViewModel @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _addNewAdress = MutableStateFlow<Resource<Adress>>(Resource.Unspecified())
    val addNewAdress = _addNewAdress.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    fun addAdress(adress: Adress) {

        val validateInputs = validateInputs(adress)

        if (validateInputs) {
            viewModelScope.launch { _addNewAdress.emit(Resource.Loading()) }
            firestore.collection("user").document(auth.uid!!).collection("adress").document()
                .set(adress).addOnSuccessListener {
                    viewModelScope.launch { _addNewAdress.emit(Resource.Success(adress)) }
                }.addOnFailureListener {
                    viewModelScope.launch { _addNewAdress.emit(Resource.Error(it.message.toString())) }
                }
        }else {
            viewModelScope.launch {
                _error.emit("All fields are requiered")
            }
        }
    }

    private fun validateInputs(adress: Adress): Boolean {
        return adress.adressTitle.trim().isNotEmpty() &&
                adress.city.trim().isNotEmpty() &&
                adress.phone.trim().isNotEmpty() &&
                adress.state.trim().isNotEmpty() &&
                adress.fullName.trim().isNotEmpty() &&
                adress.street.trim().isNotEmpty()

    }


}