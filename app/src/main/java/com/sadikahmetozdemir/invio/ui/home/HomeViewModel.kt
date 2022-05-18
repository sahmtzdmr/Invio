package com.sadikahmetozdemir.invio.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sadikahmetozdemir.invio.base.BaseViewModel
import com.sadikahmetozdemir.invio.core.repository.DefaultRepository
import com.sadikahmetozdemir.invio.core.shared.remote.MovieResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DefaultRepository) :
    BaseViewModel() {
    var searchTextET = MutableLiveData("")
    private val _movies: MutableLiveData<MovieResponseModel> = MutableLiveData()
    val movies: LiveData<MovieResponseModel> get() = _movies

    fun searchMovieRequest(searchText: String) {

        sendRequest(
            request = {
                showLoading()
                repository.searchMovieRequest(searchText)
            },
            error = {
                it
                hideLoading()
            },
            success = {
                hideLoading()
                if (it.Genre.isNullOrEmpty() && it.Poster.isNullOrEmpty() && it.Plot.isNullOrEmpty()) {
                    showMessage("Girdiğiniz kelimelerle ilgili bir şey bulamadık")
                } else
                    _movies.value = it

            })
    }

    fun toDetail(movieResponseModel: MovieResponseModel) {

        navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movieResponseModel))

    }
}
