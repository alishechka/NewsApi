package com.example.newsapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapi.repository.RepositoryInterface

class NewsViewModelFactory (private val repo:RepositoryInterface):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(repo) as T
    }
}