package com.showcase.topratedmovies.business

import com.showcase.topratedmovies.business.entity.Movie
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * The class represents the use case of retrieving the top movie list
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class GetTopMovieList constructor(private val repository: Repository) {

    fun execute(successValue: (movieList: List<Movie>) -> Unit, errorValue: (error: Throwable) -> Unit) {
        doAsync {
            repository.getTopMovieList({ list ->
                uiThread { list.let(successValue) }
            }, { error ->
                uiThread { error.let(errorValue) }
            })
        }
    }
}