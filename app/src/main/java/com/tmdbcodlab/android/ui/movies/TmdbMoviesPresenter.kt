package com.tmdbcodlab.android.ui.movies

import com.bumptech.glide.Glide.init
import com.tikalk.mobileevent.mobileevent.BaseView
import com.tmdbcodlab.android.data.TmdbRepository
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import timber.log.Timber

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbMoviesPresenter(val repository: TmdbRepository) : MoviesContract.Presenter {

    lateinit var moviesView: MoviesContract.View
    val compositeDisposal = CompositeDisposable()


    override fun subscribe(view : BaseView) {
        this.moviesView = view as MoviesContract.View
    }

    override fun unsubscribe() {
    }

    override fun loadMovies(forceUpdate: Boolean) {
        Timber.d("About to load movies")


        val subscribe: Disposable = repository.getMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {movies ->
                            run {
                                Timber.d("onNext: ${movies.isEmpty()}")
                                moviesView.showMovies(movies)
                            }
                        },
                        {t -> Timber.e(t)})


        compositeDisposal.add(subscribe)

    }

}