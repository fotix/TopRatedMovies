package com.showcase.topratedmovies.data.datasource.mapper

import com.showcase.topratedmovies.business.entity.Movie
import com.showcase.topratedmovies.business.entity.MovieDetail
import com.showcase.topratedmovies.data.datasource.model.MovieDetailResponse
import com.showcase.topratedmovies.data.datasource.model.MovieListResponse

/**
 * The class is responsible to map all the models from the API to our business entities
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class MovieMapper {
    private val IMAGE_BASE_URL_1280 = "http://image.tmdb.org/t/p/w1280"
    private val IMAGE_BASE_URL_500 = "http://image.tmdb.org/t/p/w500"

    fun mapMovieListResponseToMovieList(movieListResponse: MovieListResponse): List<Movie> {
        val movieList = mutableListOf<Movie>()

        movieListResponse.results.forEach {
            movieList.add(
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    IMAGE_BASE_URL_1280 + it.backdropPath,
                    IMAGE_BASE_URL_500 + it.posterPath,
                    it.releaseDate
                )
            )
        }

        return movieList
    }

    fun mapMovieDetailResponseToMovieDetail(movieDetailResponse: MovieDetailResponse): MovieDetail {
        return MovieDetail(
            movieDetailResponse.id,
            movieDetailResponse.title,
            movieDetailResponse.overview,
            IMAGE_BASE_URL_1280 + movieDetailResponse.backdropPath,
            IMAGE_BASE_URL_500 + movieDetailResponse.posterPath,
            movieDetailResponse.releaseDate,
            movieDetailResponse.voteAverage
        )
    }
}