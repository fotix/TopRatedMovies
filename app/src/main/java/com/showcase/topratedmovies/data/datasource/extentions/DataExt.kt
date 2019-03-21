package com.showcase.topratedmovies.data.datasource.extentions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The class hold all extentions needed in the data layer
 * <p>
 * Copyright (C) 2019, Bosch Thermotechnik GmbH
 * </p>
 *
 * @author <a href="mailto:FilipeFerreira.Oliveira@pt.bosch.com">Filipe Oliveira</a>
 */

//Just a helping extension, should be in a proper file
fun <T> Call<T>.enqueue(
    success: (response: Response<T>) -> Unit,
    failure: (t: Throwable) -> Unit
) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>) = success(response)

        override fun onFailure(call: Call<T>?, t: Throwable) = failure(t)
    })
}

