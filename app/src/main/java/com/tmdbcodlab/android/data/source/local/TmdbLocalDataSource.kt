package com.tmdbcodlab.android.data.source.local

import com.tmdbcodlab.android.data.source.TmdbDataSource
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbLocalDataSource(val dao: MoviesDao): TmdbDataSource {

    override fun getMovies(): Flowable<List<Movie>> {
        return dao.getAllMovies()
    }

    override fun insertMovies(movies: List<Movie>) {
        dao.insertMovies(movies)
    }

    override fun insertMovie(movie: Movie) {
        dao.insertMovie(movie)
    }

    override fun getMovie(id: Int) : Movie{
        return dao.getMovieById(id)
    }



}