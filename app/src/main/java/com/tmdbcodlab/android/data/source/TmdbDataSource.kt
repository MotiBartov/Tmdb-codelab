package com.tmdbcodlab.android.data.source

import com.tmdbcodlab.android.io.Movie
import io.reactivex.Observable

/**
 * Created by ronelg on 12/19/17.
 */
interface TmdbDataSource {
    fun saveMovies(movies : List<String>)
    fun saveMovie(movie: String)
    fun getMovies() : Observable<List<Movie>?>
    fun getMovie(id: Int)

}