package com.sadikahmetozdemir.invio.core.utils

import com.sadikahmetozdemir.invio.utils.Constant
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class NetworkInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("apikey", Constant.API_KEY)
            .build()
        val request: Request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
