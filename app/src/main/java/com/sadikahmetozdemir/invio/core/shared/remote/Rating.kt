package com.sadikahmetozdemir.invio.core.shared.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    val Source: String,
    val Value: String
) : Parcelable
