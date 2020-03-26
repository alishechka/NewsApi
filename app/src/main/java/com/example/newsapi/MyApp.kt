package com.example.newsapi

import android.app.Application
import com.example.newsapi.dagger.components.AppComponent
//import com.example.newsapi.dagger.DaggerAppComponent
import com.example.newsapi.dagger.components.DaggerAppComponent
import com.example.newsapi.dagger.modules.DatabaseModule
import com.example.newsapi.dagger.modules.NetworkModule

class MyApp : Application() {


    override fun onCreate() {
        super.onCreate()
        component()
    }

    fun component():AppComponent {
        return DaggerAppComponent.builder()
            .databaseModule(
                DatabaseModule(
                    applicationContext
                )
            )
            .networkModule(NetworkModule()).build()
    }
}
