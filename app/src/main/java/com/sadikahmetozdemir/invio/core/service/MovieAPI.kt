package com.sadikahmetozdemir.invio.core.service

import com.sadikahmetozdemir.invio.core.shared.remote.MovieResponseModel
import com.sadikahmetozdemir.invio.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET(".")
    suspend fun searchMovieRequest(@Query("t") searchText: String): MovieResponseModel


}