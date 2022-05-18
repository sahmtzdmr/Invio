package com.sadikahmetozdemir.invio.utils

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import com.sadikahmetozdemir.invio.R

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.custom_loading)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(0))
    }
}
