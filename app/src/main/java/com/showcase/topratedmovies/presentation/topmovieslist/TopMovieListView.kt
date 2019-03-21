package com.showcase.topratedmovies.presentation.topmovieslist

import com.showcase.topratedmovies.business.entity.Movie

/**
 * The class is the generic representation of a view for the Top Movie List
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
interface TopMovieListView {
    fun showMovieList(movieList: List<Movie>)
    fun showError(error: Throwable)
}