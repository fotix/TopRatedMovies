package com.showcase.topratedmovies.presentation.topmoviesdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.showcase.topratedmovies.R
import com.showcase.topratedmovies.business.GetMovieDetail
import com.showcase.topratedmovies.business.entity.MovieDetail
import com.showcase.topratedmovies.data.DataRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_top_movie_detail.*
import org.jetbrains.anko.toast


class TopMovieDetailActivity : AppCompatActivity(), TopMovieDetailView {

    private lateinit var topMovieDetailPresenter: TopMovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movie_detail)
        supportActionBar?.hide()
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)

        topMovieDetailPresenter = TopMovieDetailPresenter(this, GetMovieDetail(DataRepository.instance))

        topMovieDetailPresenter.loadMovieDetail(intent.getIntExtra("movieid", 0))

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showMovieDetail(movieDetail: MovieDetail) {
        Picasso.get()
            .load(movieDetail.imageUrl)
            .into(media_image)

        Picasso.get()
            .load(movieDetail.posterUrl)
            .into(avatar_image)

        primary_text.text = movieDetail.title
        sub_text.text = "Released on ${movieDetail.releaseDate}"
        supporting_text.text = movieDetail.description
        rating_text.text = "${movieDetail.averageVoting} / 10"
    }

    override fun showError(error: Throwable) {
        toast("Error -  ${error.message}")
    }

}
