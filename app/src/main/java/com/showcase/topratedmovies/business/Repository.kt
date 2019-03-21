package com.showcase.topratedmovies.business

import com.showcase.topratedmovies.business.entity.Movie
import com.showcase.topratedmovies.business.entity.MovieDetail

/**
 * The class is the repository interface that represents the data layer interface
 * for the business layer. All data methods required by the user cases should be
 * declared here and implemented by the specific repository implementation
 *
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
interface Repository {
    fun getTopMovieList(successValue: (movieList: List<Movie>) -> Unit, error: (t: Throwable) -> Unit)
    fun getMovieDetail(movieId: Int, successValue: (movieDetail: MovieDetail) -> Unit, error: (t: Throwable) -> Unit)
}