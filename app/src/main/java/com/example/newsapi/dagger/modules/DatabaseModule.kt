package com.example.newsapi.dagger.modules

import android.content.Context
import androidx.room.Room
import com.example.newsapi.common.database.NewsDao
import com.example.newsapi.common.database.NewsDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideDatabase(): NewsDataBase {
        return Room.databaseBuilder(
            context, NewsDataBase::class.java, "news_table"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(newsDataBase: NewsDataBase): NewsDao {
        return newsDataBase.newsDao()
    }

}