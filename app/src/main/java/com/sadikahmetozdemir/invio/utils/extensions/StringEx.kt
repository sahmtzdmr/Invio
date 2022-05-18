package com.sadikahmetozdemir.invio.utils.extensions

import android.graphics.Color
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sadikahmetozdemir.invio.R

fun Fragment.snackbar(message: String) {
    this.let { view ->
        val snackbar = Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG)
        snackbar.setAction(R.string.text_action) { snackbar.dismiss() }
        val view = snackbar.view
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }
}
