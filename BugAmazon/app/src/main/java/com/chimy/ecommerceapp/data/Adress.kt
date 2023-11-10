package com.chimy.ecommerceapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Adress(
    val adressTitle: String,
    val fullName: String,
    val street: String,
    val phone: String,
    val city: String,
    val state: String,

): Parcelable{

    constructor(): this("","","","","","")
}
