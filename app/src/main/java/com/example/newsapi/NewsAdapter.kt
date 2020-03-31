package com.example.newsapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.common.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*


class NewsAdapter(
    private val model: List<News>,
    private val itemClicked: onItemClicked
) :
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
        setScaleAnimation(holder.itemView)

        holder.title.text = model[position].title
        holder.description.text = model[position].description
        val imageUrl = model[position].urlToImage
        Picasso.get().load(imageUrl).into(holder.image)

        holder.itemView.setOnClickListener {
            itemClicked.onClickItem(model[position].url)
        }
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container = itemView.item_layout
        val image = itemView.iv_news
        val title = itemView.tv_title
        val description = itemView.tv_description


    }

    private fun setScaleAnimation(view: View) {
        val anim = ScaleAnimation(
            0.0f,
            1.0f,
            0.0f,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        anim.duration = 1000
        view.startAnimation(anim)
    }
}