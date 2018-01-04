package com.tmdbcodlab.android.ui.details

import com.tmdbcodlab.android.data.TmdbRepository
import dagger.Module
import dagger.Provides

/**
 * Created by motibartov on 04/01/2018.
 */

@Module
class DetailsModule {

    @Provides
    fun provideDetailsPresenter(repository: TmdbRepository) : DetailsContract.Presenter{
        return TmdbDetailsPresenter(repository)
    }
}