package com.chimy.ecommerceapp.util

sealed class RegisterValidation() {
    object Success : RegisterValidation()
    data class Failed(val message: String) : RegisterValidation()
}

data class registerFieldState(
    val email: RegisterValidation,
    val password: RegisterValidation
)

