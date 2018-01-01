package com.tmdbcodlab.android.ui.movies

import android.util.Log
import com.tmdbcodlab.android.data.TmdbRepository
import com.tmdbcodlab.android.io.Movie
import io.reactivex.FlowableSubscriber
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
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


        repository.getMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : FlowableSubscriber<List<Movie>>{
                    override fun onComplete() {
                        Timber.d("onComplete")
                    }

                    override fun onSubscribe(s: Subscription) {
                        Timber.d("onSubscribe")
                        s.request(Long.MAX_VALUE)
                    }

                    override fun onNext(t: List<Movie>) {
                        Timber.d("onNext")
                        moviesView.showMovies(t)
                    }

                    override fun onError(t: Throwable?) {
                        Timber.e(t)
                    }

                })
    }

}