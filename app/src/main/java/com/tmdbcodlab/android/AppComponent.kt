package com.tmdbcodlab.android

import com.tmdbcodlab.android.api.ApiModule
import com.tmdbcodlab.android.data.source.local.RoomModule
import com.tmdbcodlab.android.ui.details.DetailsActivty
import com.tmdbcodlab.android.ui.details.DetailsModule
import com.tmdbcodlab.android.ui.movies.MoviesActivity
import com.tmdbcodlab.android.ui.movies.MoviesModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by motibartov on 20/12/2017.
 */
@Component(modules = arrayOf(AppModule::class, ApiModule::class, MoviesModule::class, RoomModule::class, DetailsModule::class))
@Singleton
interface AppComponent{


    fun injectMovies(target: MoviesActivity)
    fun injectDetails(target: DetailsActivty)


}