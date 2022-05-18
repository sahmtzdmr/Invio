package com.sadikahmetozdemir.invio.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.snackbar.Snackbar
import com.sadikahmetozdemir.invio.R
import com.sadikahmetozdemir.invio.base.BaseFragment
import com.sadikahmetozdemir.invio.core.shared.remote.MovieResponseModel
import com.sadikahmetozdemir.invio.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner) {
            val movieList = ArrayList<MovieResponseModel>()
            movieList.add(it)
            homeAdapter = HomeAdapter(movieList)
            binding.recylerView.apply {
                setHasFixedSize(true)
                adapter = homeAdapter
            }
            homeAdapter.itemClicked = {
                viewModel.toDetail(it)
            }
        }

        binding.btSearch.setOnClickListener {
            if (binding.searchView.text.isNullOrEmpty()) {
                val snackbar =
                    Snackbar.make(view, "Arama alanı boş kalamaz", Snackbar.LENGTH_LONG)
                val snackbarView = snackbar.view
                val params = view.layoutParams as FrameLayout.LayoutParams
                params.gravity = Gravity.TOP
                this.view?.layoutParams = params
                snackbarView.setBackgroundColor(Color.RED)
                snackbar.show()
            } else
                viewModel.searchMovieRequest(binding.searchView.text?.trim().toString())
        }
    }
}
