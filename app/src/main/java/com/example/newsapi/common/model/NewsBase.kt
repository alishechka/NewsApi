package com.example.newsapi.common.model

import com.google.gson.annotations.SerializedName

data class NewsBase(

    val status: String,
    val totalResults: Int,
    val articles: List<News>
)