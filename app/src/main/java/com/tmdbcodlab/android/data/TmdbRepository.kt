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
//            loadMoviesFromRemote()
        }
    }

    override fun getMovie(id: Int): Movie {
        throw UnsupportedOperationException("Unsupported operation")
    }

    fun loadMoviesFromLocal(): Flowable<List<Movie>> {
        Timber.d("Prepare f1 from local datasource")
        return localDataSource.getMovies().
                take(1)
                .flatMap { list -> Flowable.fromIterable(list) }
                .doOnNext{
                    item -> cache.add(item)
                }
                .toList()
                .toFlowable()
                .filter{l -> !l.isEmpty()}
                .switchIfEmpty(loadMoviesFromRemote())
    }

    fun loadMoviesFromRemote(): Flowable<List<Movie>> {
        Timber.d("Prepare the f1 from remote datasource")
        return remoteDataSource.getMovies().doOnNext{ list ->
            cache.clear()
            cache.addAll(list)
        }
    }

}