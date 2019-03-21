package com.showcase.topratedmovies.business

import com.showcase.topratedmovies.business.entity.MovieDetail
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * The class represents the use case of retrieving the use case of a movie detail
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class GetMovieDetail constructor(private val repository: Repository) {

    fun execute(movieId: Int, success: (MovieDetail) -> Unit, error: (Throwable) -> Unit) {
        doAsync {
            repository.getMovieDetail(movieId, { movieDetail ->
                uiThread { movieDetail.let(success) }
            }, { errorResult ->
                uiThread { errorResult.let(error) }
            })
        }
    }
}