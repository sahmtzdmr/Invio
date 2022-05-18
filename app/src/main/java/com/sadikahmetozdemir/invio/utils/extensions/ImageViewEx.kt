package com.sadikahmetozdemir.invio.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sadikahmetozdemir.invio.R

fun ImageView.load(isFadeInEnabled: Boolean = true, url: String?) {
    val duration = if (isFadeInEnabled)50 else 0
    Glide
        .with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade(duration))
        .into(this)
}