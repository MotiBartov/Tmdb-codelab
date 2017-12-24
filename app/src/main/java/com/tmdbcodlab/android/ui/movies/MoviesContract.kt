package com.tmdbcodlab.android.ui.movies

import com.tikalk.mobileevent.mobileevent.BasePresenter
import com.tikalk.mobileevent.mobileevent.BaseView

/**
 * Created by ronelg on 12/19/17.
 */
interface MoviesContract {

    interface View : BaseView {

        fun setLoadingIndicator(active: Boolean)
        fun showViewReady()
    }
    interface Presenter : BasePresenter {

        fun setView(view : View)
        fun loadMovies(forceUpdate: Boolean)
    }
}