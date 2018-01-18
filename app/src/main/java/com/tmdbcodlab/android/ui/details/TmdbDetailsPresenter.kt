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


    var detailsView: DetailsContract.View? = null

    override fun attach(view : BaseView) {
        detailsView = view as DetailsContract.View
    }

    override fun detach() {
        detailsView = null
    }

    override fun loadMovie(id: Int) {
        Timber.d("About to load movie $id")
        repository.getMovie(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(({m ->
                    detailsView?.showMovie(m)
                    Timber.d("onNext: $m")
                }),({e -> Timber.e(e)}))
    }
}