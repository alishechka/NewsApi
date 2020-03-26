package com.example.newsapi.dagger.components

import com.example.newsapi.MyApp
import com.example.newsapi.common.database.NewsDao
import com.example.newsapi.common.network.NewsClient
import com.example.newsapi.dagger.modules.DatabaseModule
import com.example.newsapi.dagger.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(myApp: MyApp)
    fun client(): NewsClient
    fun newsDao(): NewsDao


}