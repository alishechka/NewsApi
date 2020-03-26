package com.example.newsapi.repository

import com.example.newsapi.common.database.NewsDao
import com.example.newsapi.common.model.News
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(private val repo: NewsDao) : LocalRepositoryInterface {
    override fun getNews(): List<News> {
        return repo.getAllNews()
    }

    override fun addNews(vararg news: News) {
        return repo.addAllNews(*news)
    }

}
