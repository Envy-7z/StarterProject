package com.wisnua.starterproject.data.repository

import com.wisnua.starterproject.data.remote.ApiService
import com.wisnua.starterproject.domain.model.NewsResponse
import com.wisnua.starterproject.domain.repository.NewsRepository

class NewsRepositoryImpl(private val apiService: ApiService) : NewsRepository {
    override suspend fun getTopNews(page: Int, pageSize: Int, country: String): NewsResponse {
        return apiService.getTopNews(page, pageSize, country)
    }
}