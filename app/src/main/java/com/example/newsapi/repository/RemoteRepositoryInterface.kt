package com.example.newsapi.repository

import com.example.newsapi.common.model.News

interface RemoteRepositoryInterface {
    suspend fun getTopNews(): List<News>
}