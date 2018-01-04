package com.tmdbcodlab.android.data.source

import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by ronelg on 12/19/17.
 */
interface TmdbDataSource {
    fun insertMovies(movies : List<Movie>)
    fun insertMovie(movie: Movie)
    fun getMovies() : Flowable<List<Movie>>
    fun getMovie(id: Int) : Flowable<Movie>
}