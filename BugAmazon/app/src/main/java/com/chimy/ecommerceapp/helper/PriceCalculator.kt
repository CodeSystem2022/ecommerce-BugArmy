package com.chimy.ecommerceapp.helper

fun Float?.getProductPrice(price: Float): Float{
    //this --> percentage
    if (this == null)
        return price
    val remainingPricePercentage = 1 - this
    val priceAfterOffer = remainingPricePercentage * price

    return priceAfterOffer
}