package com.showcase.topratedmovies

import android.app.Application
import android.util.Log
import com.showcase.topratedmovies.data.DataRepository
import com.squareup.picasso.Picasso

/**
 * The class is responsible
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
class TopMoviesApplication : Application()  {

    override fun onCreate() {
        super.onCreate()
        Log.d("[TopMoviesApplication]","Creating singletons")
        //Initializing singletons
        DataRepository.initialize()
        Picasso.get().isLoggingEnabled = true
    }
}