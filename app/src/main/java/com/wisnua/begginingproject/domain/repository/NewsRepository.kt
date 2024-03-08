package com.wisnua.begginingproject.domain.repository
import com.wisnua.begginingproject.domain.model.NewsResponse

interface NewsRepository {
    suspend fun getTopNews(page: Int, pageSize: Int, country: String): NewsResponse
}

