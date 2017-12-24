package com.tmdbcodlab.android

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by motibartov on 20/12/2017.
 */
@Module
class AppModule(internal var application: MyApplication) {


    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return this.application
    }
}
