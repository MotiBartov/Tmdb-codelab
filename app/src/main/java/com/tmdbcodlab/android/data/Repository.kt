package com.tmdbcodlab.android.data

import com.tmdbcodlab.android.io.Movie
import io.reactivex.Observable

/**
 * Created by motibartov on 24/12/2017.
 */
interface Repository {
    fun loadMoviesFromLocal() : Observable<List<Movie>?>
    fun loadMoviesFromRemote() : Observable<List<Movie>?>
}