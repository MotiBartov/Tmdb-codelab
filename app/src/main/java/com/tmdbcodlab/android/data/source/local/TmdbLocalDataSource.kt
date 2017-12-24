package com.tmdbcodlab.android.data.source.local

import com.tmdbcodlab.android.data.source.TmdbDataSource
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Observable

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbLocalDataSource: TmdbDataSource {
    override fun saveMovies(movies: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveMovie(movie: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getMovies() : Observable<List<Movie>?>{
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}