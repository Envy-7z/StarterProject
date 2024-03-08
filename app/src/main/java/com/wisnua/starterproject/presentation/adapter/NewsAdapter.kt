package com.wisnua.starterproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.wisnua.starterproject.R
import com.wisnua.starterproject.databinding.ContentNewsBinding
import com.wisnua.starterproject.domain.model.Article

class NewsAdapter : PagingDataAdapter<Article, NewsAdapter.NewsViewHolder>(ArticleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ContentNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = getItem(position)
        article?.let { holder.bind(it) }
    }

    inner class NewsViewHolder(private val binding: ContentNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.apply {
                tvTitle.text = article.title
                tvSubTitle.text = article.author ?: "Unknown Author"
                tvDesc.text = article.publishedAt ?: "No description available"

                if (article.urlToImage != null) {
                    Glide.with(root)
                        .load(article.urlToImage)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ivImage)
                } else {
                    // Load placeholder image
                    ivImage.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.baseline_browser_not_supported_24))
                }
            }
        }
    }

    class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}
