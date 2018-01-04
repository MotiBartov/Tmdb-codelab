package com.tmdbcodlab.android.ui.details

import com.tikalk.mobileevent.mobileevent.BaseView
import com.tmdbcodlab.android.data.TmdbRepository
import com.tmdbcodlab.android.ui.movies.MoviesContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by motibartov on 04/01/2018.
 */
class TmdbDetailsPresenter(val repository: TmdbRepository) : DetailsContract.Presenter {


    lateinit var detailsView: DetailsContract.View

    override fun subscribe(view : BaseView) {
        detailsView = view as DetailsContract.View
    }

    override fun unsubscribe() {
    }

    override fun loadMovie(id: Int) {
        Timber.d("About to load movie $id")
        repository.getMovie(id)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(({m ->
                    detailsView.showMovie(m)
                    Timber.d("onNext: $m")
                }),({e -> Timber.e(e)}))
    }
}