package com.tmdbcodlab.android.data

import com.tmdbcodlab.android.data.source.remote.TmdbRemoteDataSource
import com.tmdbcodlab.android.data.source.local.TmdbLocalDataSource
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Observable
import timber.log.Timber

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbRepository(val remoteDataSource: TmdbRemoteDataSource, val localDataSource: TmdbLocalDataSource): Repository {

    fun loadMovies() : Observable<List<Movie>?>{
        Timber.d("About to load movies from repository")
        return loadMoviesFromLocal().switchIfEmpty(loadMoviesFromRemote())
    }

    override fun loadMoviesFromLocal() : Observable<List<Movie>?>{
        Timber.d("About get movies from remote datasource")
        return remoteDataSource.getMovies()
    }

    override fun loadMoviesFromRemote() : Observable<List<Movie>?>{
        return Observable.empty()
    }


}