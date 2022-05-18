package com.sadikahmetozdemir.invio.ui.detail

import com.sadikahmetozdemir.invio.R
import com.sadikahmetozdemir.invio.base.BaseFragment
import com.sadikahmetozdemir.invio.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>(R.layout.fragment_movie_detail)
