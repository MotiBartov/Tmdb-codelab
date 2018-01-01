package com.tmdbcodlab.android.api

import com.tmdbcodlab.android.io.ApiResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by ronelg on 12/19/17.
 */
interface TmdbService {


    @GET ("top_rated")
    fun getTopRated() : Flowable<ApiResponse>

}