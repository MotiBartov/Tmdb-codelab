package com.tmdbcodlab.android.api

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

/**
 * Created by motibartov on 20/12/2017.
 */

@Module
class ApiModule{

    companion object {
        val BASE_URL = "http://api.themoviedb.org/3/movie/"
        val KEY = "b331218ddcbd128634135abf7673fab5"
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(logInterceptor).addInterceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder().addQueryParameter("api_key", KEY).build()
            Timber.d("new Url: $url")
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }.build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder().
                baseUrl(BASE_URL).
                client(client).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build()
    }

    @Provides
    @Singleton
    fun provideTmdbService(retrofit : Retrofit) : TmdbService{
        return retrofit.create(TmdbService::class.java)
    }



}