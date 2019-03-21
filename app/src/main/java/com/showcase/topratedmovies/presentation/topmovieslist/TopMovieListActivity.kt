package com.showcase.topratedmovies.presentation.topmovieslist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.showcase.topratedmovies.R
import com.showcase.topratedmovies.business.GetTopMovieList
import com.showcase.topratedmovies.business.entity.Movie
import com.showcase.topratedmovies.data.DataRepository
import com.showcase.topratedmovies.presentation.topmoviesdetails.TopMovieDetailActivity
import kotlinx.android.synthetic.main.activity_top_movies_list.*
import org.jetbrains.anko.toast


/**
 * The class is the activity responsible to show the user interface for‹ the top movies list
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class TopMovieListActivity : AppCompatActivity(), TopMovieListView {
    private val tag = this.javaClass.simpleName

    //Activity presenter
    private lateinit var presenter: TopMovieListPresenter

    //List related
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: TopMovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movies_list)
        Log.d("[TopMovieListActivity]", "Creating TopMovieListActivity")

        setupViews()
        setupPresenter()

        presenter.getTopMovieList()
    }

    private fun setupViews() {
        adapter = TopMovieListAdapter { onMovieDetailClicked(it) }

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view_movie_list.layoutManager = linearLayoutManager
        recycler_view_movie_list.adapter = adapter
    }

    private fun onMovieDetailClicked(movie: Movie) {

        val intent = Intent(this, TopMovieDetailActivity::class.java)
        intent.putExtra("movieid",movie.id)
        startActivity(intent)

    }

    private fun setupPresenter() {
        presenter = TopMovieListPresenter(this, GetTopMovieList(DataRepository.instance))
    }


    override fun showMovieList(movieList: List<Movie>) {
        adapter.setData(movieList)
    }

    override fun showError(error: Throwable) {
        Log.e(tag, "[TopMovieListActivity]   -  Error:  $error")
        toast("Error -  ${error.message}")
    }

}
