package com.showcase.topratedmovies.presentation.topmoviesdetails

import com.showcase.topratedmovies.business.entity.MovieDetail

/**
 * The class is the generic representation of a view for the details of a top movie
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
interface TopMovieDetailView {
    fun showMovieDetail(movieDetail: MovieDetail)
    fun showError(error: Throwable)
}