package com.example.newsapi.repository

import com.example.newsapi.common.model.News

interface RepositoryInterface {

     fun makeRetrofitCall(): List<News>
    fun getDataFromLocal(): List<News>
    fun addDataToLocal(vararg news: News)

}
