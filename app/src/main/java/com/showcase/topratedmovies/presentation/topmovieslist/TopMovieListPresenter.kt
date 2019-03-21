package com.showcase.topratedmovies.presentation.topmovieslist

import com.showcase.topratedmovies.business.GetTopMovieList

/**
 * The class is the presenter responsible to coordinate the [TopMovieListActivity]
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class TopMovieListPresenter constructor(
    private val topMovieListView: TopMovieListView,
    private val getTopMovieList: GetTopMovieList){

    fun getTopMovieList(){
        getTopMovieList.execute({
            topMovieListView.showMovieList(it)
        },{
            topMovieListView.showError(it)
        })
    }
}