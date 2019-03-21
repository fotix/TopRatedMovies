package com.showcase.topratedmovies.presentation.topmoviesdetails

import com.showcase.topratedmovies.business.GetMovieDetail

/**
 * The class is responsible
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class TopMovieDetailPresenter constructor(
    private val topMovieDetailView: TopMovieDetailView,
    private val getMovieDetail: GetMovieDetail) {

    fun loadMovieDetail(id: Int) {
        getMovieDetail.execute(id,{
            topMovieDetailView.showMovieDetail(it)
        },{
            topMovieDetailView.showError(it)
        })
    }

}