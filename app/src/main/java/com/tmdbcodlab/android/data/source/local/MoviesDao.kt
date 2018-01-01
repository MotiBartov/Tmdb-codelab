package com.tmdbcodlab.android.data.source.local

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by motibartov on 01/01/2018.
 */
@Dao
interface MoviesDao {

    @Insert(onConflict = REPLACE)
    fun insertMovies(movies : List<Movie>)

    @Insert(onConflict = REPLACE)
    fun insertMovie(movie: Movie)

    @Query("SELECT * FROM movies")
    fun getAllMovies() : Flowable<List<Movie>>

    @Query("SELECT * FROM movies WHERE id = :arg0")
    fun getMovieById(id : Int) : Movie

    @Update(onConflict = REPLACE)
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)
}