package com.awak.wekare

import android.content.Context
import com.awak.wekare.WeKareApplication

import dagger.Component
import javax.inject.Singleton

/**
 *  @Component Definition of the Application graph
 * @Singleton Single Instance
 **/
@Singleton
@ApplicationScope
@Component(modules = [AppModule::class])
interface ApplicationComponent {


    //A Builder here is basically a more versatile (and less verbose!) builder.
    //compile time safety
    //For testing
    @ApplicationContext
    fun context(): Context






    fun inject(application:WeKareApplication)
}
