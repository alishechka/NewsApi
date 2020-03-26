package com.example.newsapi.common.network

import com.example.newsapi.common.API_KEY
import com.example.newsapi.common.ENDPOINT_DIRECTORY_TOP_HEADLINES
import com.example.newsapi.common.ENDPOINT_QUERY_API_KEY
import com.example.newsapi.common.ENDPOINT_QUERY_COUNTRY
import com.example.newsapi.common.model.NewsBase
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsClient {

    @GET(ENDPOINT_DIRECTORY_TOP_HEADLINES)
    fun getHeadlines(
        @Query(ENDPOINT_QUERY_COUNTRY) country: String = "us",
        @Query(ENDPOINT_QUERY_API_KEY) apiKey: String = API_KEY
    ): NewsBase
}