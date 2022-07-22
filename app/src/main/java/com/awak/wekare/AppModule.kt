package com.awak.wekare

import android.app.Application
import android.content.Context
import com.awak.wekare.BuildConfig

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(private var mApplication: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return mApplication
    }

    @Provides
    @ApplicationScope
    fun provideApplication(): Application {
        return mApplication
    }


    @Singleton
    @Provides
    fun provideIsDebug(): Boolean {
        return BuildConfig.DEBUG
    }



}