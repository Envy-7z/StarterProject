package com.wisnua.begginingproject.data.repository

import com.wisnua.begginingproject.data.remote.ApiService
import com.wisnua.begginingproject.domain.model.Article
import com.wisnua.begginingproject.domain.model.NewsResponse
import com.wisnua.begginingproject.domain.repository.NewsRepository

class NewsRepositoryImpl(private val apiService: ApiService) : NewsRepository {
    override suspend fun getTopNews(page: Int, pageSize: Int, country: String): NewsResponse {
        return apiService.getTopNews(page, pageSize, country)
    }
}