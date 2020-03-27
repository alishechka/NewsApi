package com.example.newsapi.repository

import com.example.newsapi.common.model.News
import com.example.newsapi.common.network.NewsClient
import javax.inject.Inject

class RetrofitRepositoryImpl @Inject constructor(private val client: NewsClient) : RemoteRepositoryInterface {
     override suspend fun getTopNews(): List<News> {
        return client.getHeadlines().articles
    }


}