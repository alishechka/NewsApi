package com.example.newsapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.common.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(private val model: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.text = model[position].title
        holder.description.text = model[position].description
        val imageUrl = model[position].urlToImage
        Picasso.get().load(imageUrl).into(holder.image)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.iv_news
        val title = itemView.tv_title
        val description = itemView.tv_description
    }
}