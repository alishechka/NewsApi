package com.example.newsapi

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.common.model.News
import com.example.newsapi.dagger.components.DaggerNewsViewModelComponent
import com.example.newsapi.dagger.modules.NewsViewModelModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),onItemClicked {

    @Inject
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDagger()
        initLiveData()
        initLoadData()
    }

    private fun isConnected(): Boolean {
        val cm =
            this.application?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    private fun initLoadData() {
        viewModel.getNews(isConnected())
    }

    private fun initLiveData() {
        viewModel.getNewsSuccess().observe(this, Observer {
            initRecyclerView(it)
        })
        viewModel.getNewsError().observe(this, Observer {
            tv_error.text=it
        })
    }

    private fun initRecyclerView(list: List<News>) {
        rv_news.apply {
            adapter = NewsAdapter(list,this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initDagger() {
        DaggerNewsViewModelComponent.builder()
            .appComponent((applicationContext as MyApp).component())
            .newsViewModelModule(NewsViewModelModule(this))
            .build().inject(this)
    }

    override fun onClickItem(url: String) {
        CustomTabsIntent.Builder()
            .build()
            .launchUrl(this, Uri.parse(url))
    }
}
