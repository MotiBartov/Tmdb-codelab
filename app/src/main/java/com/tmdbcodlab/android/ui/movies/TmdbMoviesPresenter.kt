package com.tmdbcodlab.android.ui.movies

import com.tmdbcodlab.android.data.TmdbRepository
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import org.reactivestreams.Subscription
import timber.log.Timber

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbMoviesPresenter(val repository: TmdbRepository): MoviesContract.Presenter {

    lateinit var moviesView : MoviesContract.View
    val flowable : Flowable<List<Movie>>
    init {
        flowable = repository.getMovies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

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

         flowable.subscribe(moviesView::showMovies)

    }

}