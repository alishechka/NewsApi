package com.example.newsapi.dagger.modules

import androidx.lifecycle.ViewModelProvider
import androidx.room.ForeignKey
import com.example.newsapi.MainActivity
import com.example.newsapi.NewsViewModel
import com.example.newsapi.NewsViewModelFactory
import com.example.newsapi.dagger.ActivityScope
import com.example.newsapi.repository.RepositoryInterface
import dagger.Module
import dagger.Provides

@Module
class NewsViewModelModule(private val activity: MainActivity) {

    @Provides
    @ActivityScope
    fun provideFactory(repository: RepositoryInterface): NewsViewModelFactory {
        return NewsViewModelFactory(repository)
    }

    @Provides
    @ActivityScope
    fun provideViewModel(factory: NewsViewModelFactory): NewsViewModel {
        return ViewModelProvider(activity, factory).get(NewsViewModel::class.java)
    }


}