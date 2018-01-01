package com.tmdbcodlab.android.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.tmdbcodlab.android.io.Movie

/**
 * Created by motibartov on 01/01/2018.
 */
@Database(entities = arrayOf(Movie::class), version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getMoviesDao() : MoviesDao
}