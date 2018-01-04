package com.tmdbcodlab.android.ui.details

import com.tikalk.mobileevent.mobileevent.BasePresenter
import com.tikalk.mobileevent.mobileevent.BaseView
import com.tmdbcodlab.android.io.Movie

/**
 * Created by motibartov on 04/01/2018.
 */
interface DetailsContract {

    interface View : BaseView{
        fun showMovie(movie: Movie)
    }

    interface Presenter : BasePresenter{
        fun loadMovie(id : Int)
    }
}