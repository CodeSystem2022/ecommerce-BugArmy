package com.chimy.ecommerceapp.util

import android.view.View
import androidx.fragment.app.Fragment
import com.chimy.ecommerceapp.R
import com.chimy.ecommerceapp.activities.ShoppingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Fragment.hideBottomNavigationView(){
    val bottomNavigationView =
        (activity as ShoppingActivity).findViewById<BottomNavigationView>(
            com.chimy.ecommerceapp.R.id.buttomNavigation
        )
    bottomNavigationView.visibility = android.view.View.GONE
}

fun Fragment.showBottomNavigationView(){
    val bottomNavigationView =
        (activity as ShoppingActivity).findViewById<BottomNavigationView>(
            com.chimy.ecommerceapp.R.id.buttomNavigation
        )
    bottomNavigationView.visibility = android.view.View.VISIBLE
}