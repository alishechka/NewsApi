package com.example.newsapi.dagger.components

import com.example.newsapi.MainActivity
import com.example.newsapi.dagger.ActivityScope
import com.example.newsapi.dagger.modules.NewsViewModelModule
import com.example.newsapi.dagger.modules.RepositoryModule
import dagger.Component

@ActivityScope
@Component(
    modules = [RepositoryModule::class, NewsViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface NewsViewModelComponent {

    fun inject(mainActivity: MainActivity)
}