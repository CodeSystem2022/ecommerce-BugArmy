package com.chimy.ecommerceapp.dialog

import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.chimy.ecommerceapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.setupBottomDialog(
    onSendClick: (String) -> Unit,

){
    val dialog = BottomSheetDialog(requireContext(),R.style.DialogStyle)
    val view = layoutInflater.inflate(R.layout.reset_password_dialog, null)
    dialog.setContentView(view)
    dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
    dialog.show()

    val edEmail = view.findViewById<EditText>(R.id.edResetPassword)
    val buttonSend = view.findViewById<Button>(R.id.buttomSendResetPassword)
    val buttonCancel = view.findViewById<Button>(R.id.buttomCancelResetPassword)

    buttonSend.setOnClickListener{
        val email = edEmail.text.toString().trim()
        onSendClick(email)
        dialog.dismiss()
    }
    buttonCancel.setOnClickListener{
        dialog.dismiss()
    }
}