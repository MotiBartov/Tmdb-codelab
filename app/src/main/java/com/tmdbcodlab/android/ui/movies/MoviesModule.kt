package com.tmdbcodlab.android.ui.movies

import com.tmdbcodlab.android.api.TmdbService
import com.tmdbcodlab.android.data.TmdbRepository
import com.tmdbcodlab.android.data.source.local.MoviesDao
import com.tmdbcodlab.android.data.source.local.TmdbLocalDataSource
import com.tmdbcodlab.android.data.source.remote.TmdbRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by motibartov on 20/12/2017.
 */

@Module
class MoviesModule{

    @Provides
    @Singleton
    fun provideMoviesPresenter(repository: TmdbRepository) : MoviesContract.Presenter{
        return TmdbMoviesPresenter(repository)
    }


    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: TmdbRemoteDataSource, localDataSource: TmdbLocalDataSource) : TmdbRepository{
        return TmdbRepository(remoteDataSource, localDataSource)
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService : TmdbService) : TmdbRemoteDataSource{
        return TmdbRemoteDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: MoviesDao) : TmdbLocalDataSource{
        return TmdbLocalDataSource(dao)
    }


    @Provides
    fun provideMoviesAdapter() : MoviesAdapter{
        return MoviesAdapter()
    }
}