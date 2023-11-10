package com.chimy.ecommerceapp.data

sealed class Category (val category: String) {

    object Chair: Category("Chair")
    object Cuppboard: Category("Cuppboard")
    object Table: Category("Table")
    object Accesory: Category("Accesory")
    object Forniture: Category("Forniture")


}