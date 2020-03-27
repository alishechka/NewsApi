package com.example.newsapi.repository

import com.example.newsapi.common.model.News
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteRepo:RemoteRepositoryInterface,
    private val localRepo:LocalRepositoryInterface
) :RepositoryInterface{
    override suspend fun makeRetrofitCall(): List<News> {
        return remoteRepo.getTopNews()
    }

    override fun getDataFromLocal(): List<News> {
        return localRepo.getNews()
    }

    override fun addDataToLocal(vararg news: News) {
        return localRepo.addNews(*news)
    }

}
