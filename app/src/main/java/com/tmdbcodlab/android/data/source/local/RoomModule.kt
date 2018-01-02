package com.tmdbcodlab.android.data.source.local

import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.annotations.Since
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by motibartov on 01/01/2018.
 */

@Module
class RoomModule{

    @Provides
    @Singleton
    fun provideDatabase(context: Context) : Database{
        return Room.databaseBuilder(context, Database::class.java, "movies-db").build()
    }

    @Provides
    @Singleton
    fun provideMoviesDao(database: Database) : MoviesDao{
        return database.getMoviesDao()
    }
}