package com.showcase.topratedmovies.data

import android.util.Log
import com.showcase.topratedmovies.business.Repository
import com.showcase.topratedmovies.business.entity.Movie
import com.showcase.topratedmovies.business.entity.MovieDetail
import com.showcase.topratedmovies.data.datasource.ApiDataSource
import com.showcase.topratedmovies.data.datasource.extentions.enqueue
import com.showcase.topratedmovies.data.datasource.mapper.MovieMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.atomic.AtomicBoolean


/**
 * The class is the implementation of the [Repository] interface.
 * It will fetch the necessary data from the API data source.
 *
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class DataRepository private constructor() : Repository {

    private val TAG = this.javaClass.simpleName
    private val BASE_URL = "https://api.themoviedb.org/3/"
    private val LANGUAGE = "en-US"
    private val API_KEY = "9b89e58cbc8ca5e7db8aa90880880e83"
    private var api: ApiDataSource
    private val mapper = MovieMapper()

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiDataSource::class.java)
    }

    companion object {
        private lateinit var INSTANCE: DataRepository
        private val initialized = AtomicBoolean()

        val instance: DataRepository get() = INSTANCE

        fun initialize() {
            if (!initialized.getAndSet(true)) {
                INSTANCE = DataRepository()
            }
        }
    }


    override fun getTopMovieList(successValue: (movieList: List<Movie>) -> Unit, error: (t: Throwable) -> Unit) {
        Log.d(TAG, "Getting top movie list")
        api.getTopMovies(API_KEY, LANGUAGE)
            .enqueue({
                Log.d(TAG, "{$it}")
                it.body()?.let { mapper.mapMovieListResponseToMovieList(it) }?.let(successValue)
            }, {
                Log.e(TAG, "{$it}")
                it.let(error)
            })
    }

    override fun getMovieDetail(
        movieId: Int,
        successValue: (movieDetail: MovieDetail) -> Unit,
        error: (t: Throwable) -> Unit
    ) {
        Log.d(TAG, "Getting movie detail for ID:{$movieId}")
        api.getMovieDetail(movieId, API_KEY, LANGUAGE)
            .enqueue({
                Log.d(TAG, "{$it}")
                it.body()?.let { mapper.mapMovieDetailResponseToMovieDetail(it) }?.let(successValue)
            }, {
                Log.e(TAG, "{$it}")
                it.let(error)
            })
    }

}
