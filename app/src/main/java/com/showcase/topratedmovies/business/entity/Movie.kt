package com.showcase.topratedmovies.business.entity

/**
 * The class is responsible
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val posterUrl: String,
    val releaseDate : String
)