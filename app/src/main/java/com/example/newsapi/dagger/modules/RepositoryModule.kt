package com.example.newsapi.dagger.modules

import com.example.newsapi.repository.*
import dagger.Binds
import dagger.Module

//Binds -> for when you want to implement an impl of an interface
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRemoteRepository(remote: RetrofitRepositoryImpl): RemoteRepositoryInterface

    @Binds
    abstract fun bindLocalRepository(local: RoomRepositoryImpl): LocalRepositoryInterface

    @Binds
    abstract fun bindRepository(repo: RepositoryImpl): RepositoryInterface

}