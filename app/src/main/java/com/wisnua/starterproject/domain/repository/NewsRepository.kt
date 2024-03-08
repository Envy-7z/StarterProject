package com.wisnua.starterproject.domain.repository
import com.wisnua.starterproject.domain.model.NewsResponse

interface NewsRepository {
    suspend fun getTopNews(page: Int, pageSize: Int, country: String): NewsResponse
}

