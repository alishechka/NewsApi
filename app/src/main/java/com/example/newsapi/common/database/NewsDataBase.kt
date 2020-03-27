package com.example.newsapi.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapi.common.model.News

@Database(entities = [News::class], version = 2)
abstract class NewsDataBase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

}