package com.sadikahmetozdemir.invio.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.sadikahmetozdemir.invio.base.BaseViewModel
import com.sadikahmetozdemir.invio.core.shared.remote.MovieResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    BaseViewModel() {
    val movie = savedStateHandle.get<MovieResponseModel>("movie")
}
