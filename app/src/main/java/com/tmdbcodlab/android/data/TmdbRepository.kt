package com.tmdbcodlab.android.data

import com.tmdbcodlab.android.data.source.TmdbDataSource
import com.tmdbcodlab.android.data.source.remote.TmdbRemoteDataSource
import com.tmdbcodlab.android.data.source.local.TmdbLocalDataSource
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable
import timber.log.Timber

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbRepository(val remoteDataSource: TmdbRemoteDataSource, val localDataSource: TmdbLocalDataSource) : TmdbDataSource {

    val cache: ArrayList<Movie> = ArrayList()

    override fun insertMovies(movies: List<Movie>) {
        throw UnsupportedOperationException("Unsupported operation")
    }

    override fun insertMovie(movie: Movie) {
        throw UnsupportedOperationException("Unsupported operation")
    }

    override fun getMovies(): Flowable<List<Movie>> {
        return if (!cache.isEmpty()) {
            Timber.d("getMovies: load from cache")
            Flowable.just(cache)
        } else {
            loadMoviesFromLocal()
        }
    }

    override fun getMovie(id: Int): Movie {
        throw UnsupportedOperationException("Unsupported operation")
    }

    fun loadMoviesFromLocal(): Flowable<List<Movie>> {
        Timber.d("About get movies from local datasource")
        return localDataSource.getMovies().doOnNext { t ->
            Timber.d("loadMoviesFromLocal: doOnNext list size ${t.size}")
            cache.clear()
            cache.addAll(t)
        }.switchIfEmpty(loadMoviesFromRemote())
    }

    fun loadMoviesFromRemote(): Flowable<List<Movie>> {
        Timber.d("It seems that the database is empty or out of date,About get movies from remote")

       return remoteDataSource.getMovies().doOnNext { t ->
               Timber.d("loadMoviesFromRemote: doOnNext")
               localDataSource.dao.insertMovies(t)
               cache.clear()
               cache.addAll(t)

       }
    }




}