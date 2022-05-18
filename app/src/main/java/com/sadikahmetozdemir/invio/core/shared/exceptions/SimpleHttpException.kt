package com.sadikahmetozdemir.invio.core.shared.exceptions

data class SimpleHttpException(
    val code: String?,
    val friendlyMessage: String?
) : Exception()
