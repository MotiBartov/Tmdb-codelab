package com.tmdbcodlab.android.data.source.remote

import com.tmdbcodlab.android.api.TmdbService
import com.tmdbcodlab.android.data.source.TmdbDataSource
import com.tmdbcodlab.android.data.source.local.MoviesDao
import com.tmdbcodlab.android.io.ApiResponse
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Function
import timber.log.Timber

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbRemoteDataSource (val apiService: TmdbService): TmdbDataSource {

    override fun insertMovies(movies: List<Movie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertMovie(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: Int) : Movie{
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovies(): Flowable<List<Movie>> {
        Timber.d("getMovies was called")
        return apiService.getTopRated().concatMap { t ->
            Flowable.just(t.results)
        }
    }
}