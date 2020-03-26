package com.example.newsapi.common.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapi.common.model.News

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAllNews(): List<News>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllNews(vararg news: News)
}