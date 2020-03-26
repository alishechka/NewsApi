package com.example.newsapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.common.model.News
import com.example.newsapi.repository.RepositoryInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class NewsViewModel(private val repo: RepositoryInterface) : ViewModel() {
    //    private val compositeDisposable = CompositeDisposable() as Threads are now done by coroutines
    private val newsSuccess = MutableLiveData<List<News>>()
    private val newsError = MutableLiveData<String>()

    fun getNewsSuccess(): LiveData<List<News>> = newsSuccess
    fun getNewsError(): LiveData<String> = newsError

    fun getNews(isConnected: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            if (isConnected) {
                try {
                    val job = repo.makeRetrofitCall().also {
                        repo.addDataToLocal(*it.toTypedArray()) //yeah boyyy!!!1
                    }
                    newsSuccess.postValue(job)
                } catch (e: Exception) {
                    newsError.postValue(e.message)
                }
            } else {
                try {
                    val job = repo.getDataFromLocal()
                    newsSuccess.postValue(job)
                } catch (e: Exception) {
                    newsError.postValue(e.message)
                }
            }//end of if/else
        }//end of Global launch
    }
}
