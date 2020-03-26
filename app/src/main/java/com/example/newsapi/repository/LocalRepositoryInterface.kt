package com.example.newsapi.repository

import com.example.newsapi.common.model.News

interface LocalRepositoryInterface {
    fun getNews(): List<News>
    fun addNews(vararg news: News)

}
