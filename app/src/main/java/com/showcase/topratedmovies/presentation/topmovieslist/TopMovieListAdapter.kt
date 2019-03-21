package com.showcase.topratedmovies.presentation.topmovieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.showcase.topratedmovies.R
import com.showcase.topratedmovies.business.entity.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ly_movie_card3.view.*

/**
 * The class is the adapter responsible to feed the recyclerview with the top movies
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class TopMovieListAdapter constructor(val clickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<TopMovieListAdapter.MovieViewHolder>() {

    private var movieList = arrayListOf<Movie>()

    fun setData(list: List<Movie>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ly_movie_card, parent, false))

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(movieList[position], clickListener)


    class MovieViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val backgroundImage: ImageView = itemView.media_image
//        private val posterImage: ImageView = itemView.img_cover_d
        private val title: TextView = itemView.primary_text
//        private val overview: TextView = itemView.sub_text
//        private val releaseDate: TextView = itemView.release_text

        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            itemView.setOnClickListener { clickListener(movie) }

            Picasso.get()
                .load(movie.imageUrl)
                .into(backgroundImage)
//
//            Picasso.get()
//                .load(movie.posterUrl)
//                .into(posterImage)

            title.text = movie.title
//            overview.text = movie.description
//            releaseDate.text = movie.releaseDate
        }
    }
}