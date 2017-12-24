package com.tmdbcodlab.android.data.source.remote

import com.tmdbcodlab.android.api.TmdbService
import com.tmdbcodlab.android.data.source.TmdbDataSource
import com.tmdbcodlab.android.io.ApiResponse
import com.tmdbcodlab.android.io.Movie
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by ronelg on 12/19/17.
 */
class TmdbRemoteDataSource (val apiService: TmdbService): TmdbDataSource {

    override fun saveMovies(movies: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveMovie(movie: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: Int) {
        apiService.getTopRated()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovies(): Observable<List<Movie>?> {
        return apiService.getTopRated().concatMap(object : Function<ApiResponse, Observable<List<Movie>?>>{
            override fun apply(t: ApiResponse): Observable<List<Movie>?> {
                return Observable.just(t.results)
            }
        })
    }
}