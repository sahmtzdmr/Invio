package com.sadikahmetozdemir.invio.ui.detail

import android.os.Bundle
import android.view.View
import com.sadikahmetozdemir.invio.MainActivity
import com.sadikahmetozdemir.invio.R
import com.sadikahmetozdemir.invio.base.BaseFragment
import com.sadikahmetozdemir.invio.databinding.FragmentMovieDetailBinding
import com.sadikahmetozdemir.invio.utils.extensions.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>(R.layout.fragment_movie_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            (activity as? MainActivity)?.title = viewModel.movie?.Title
            ivMovie.load(url = viewModel.movie?.Poster)
            tvGenre.text = viewModel.movie?.Genre
            tvPlot.text = viewModel.movie?.Plot
        }
    }
}
