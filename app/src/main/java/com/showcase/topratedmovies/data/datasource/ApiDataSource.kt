package com.showcase.topratedmovies.data.datasource

import com.showcase.topratedmovies.data.datasource.model.MovieDetailResponse
import com.showcase.topratedmovies.data.datasource.model.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * The class is retrofit interface that declares the TMDB Api paths to be used
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
interface ApiDataSource {

    @GET("movie/popular")
    fun getTopMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<MovieListResponse>

    @GET("movie/{movieId}")
    fun getMovieDetail(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ) : Call<MovieDetailResponse>
}


