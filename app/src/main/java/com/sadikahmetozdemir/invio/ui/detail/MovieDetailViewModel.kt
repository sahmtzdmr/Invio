package com.sadikahmetozdemir.invio.ui.detail

import androidx.lifecycle.MutableLiveData
import com.sadikahmetozdemir.invio.base.BaseViewModel
import com.sadikahmetozdemir.invio.core.repository.DefaultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val repository: DefaultRepository) :
    BaseViewModel() {

}
