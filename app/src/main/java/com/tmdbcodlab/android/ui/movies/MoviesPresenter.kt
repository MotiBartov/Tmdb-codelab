package com.tmdbcodlab.android.ui.movies

import android.util.Log
import com.tmdbcodlab.android.data.TmdbRepository
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by ronelg on 12/19/17.
 */
class MoviesPresenter(val repository: TmdbRepository): MoviesContract.Presenter {

    companion object {
        val TAG = "TAG_MoviesPresenter"
    }

    lateinit var moviesView : MoviesContract.View


    override fun setView(view: MoviesContract.View) {
        this.moviesView = view
        this.moviesView.showViewReady()

    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun loadMovies(forceUpdate: Boolean) {
        Timber.d("About to load movies")

        repository.loadMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<Movie>?>{
                    override fun onSubscribe(d: Disposable) {
                        Timber.d("onSubscribe")
                    }

                    override fun onNext(t: List<Movie>) {
                        Timber.d("Got a movie")
                        moviesView.showMovies(t)
                    }

                    override fun onError(e: Throwable) {
                        Timber.e(e)
                    }

                    override fun onComplete() {
                        Timber.d("onComplete")
                    }

                })
    }

}