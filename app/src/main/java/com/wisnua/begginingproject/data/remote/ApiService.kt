package com.wisnua.begginingproject.data.remote

import com.wisnua.begginingproject.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getTopNews(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("country") country: String? = "id",
        @Query("sources") source: String? = null,
        @Query("category") category: String? = null,
        @Query("apiKey") apikey : String? = "2ed1fd4648494040b64ff6585d0f0392"
    ): NewsResponse
}
