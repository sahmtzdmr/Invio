package com.sadikahmetozdemir.invio.core.repository

import com.sadikahmetozdemir.invio.core.service.MovieAPI
import javax.inject.Inject

class DefaultRepository @Inject constructor(private val movieAPI: MovieAPI) : BaseRepository() {

    suspend fun searchMovieRequest(searchText: String) =
        execute {
            movieAPI.searchMovieRequest(searchText)
        }
}

