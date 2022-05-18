package com.sadikahmetozdemir.invio.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sadikahmetozdemir.invio.core.shared.remote.MovieResponseModel
import com.sadikahmetozdemir.invio.databinding.CustomMovieItemBinding
import com.sadikahmetozdemir.invio.utils.extensions.load

class HomeAdapter(private var movieList: ArrayList<MovieResponseModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CustomMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder((binding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = movieList.get(position)
        note.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    inner class ViewHolder(val binding: CustomMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

        }


        fun bind(item: MovieResponseModel) {
            binding.apply {
                ivMovie.load(url = item.Poster)
                tvMovieTitle.text = item.Title
                tvGenre.text = item.Genre
                tvDescription.text = item.Plot

            }
        }
    }
}
