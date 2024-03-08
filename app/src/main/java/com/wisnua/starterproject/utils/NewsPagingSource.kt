package com.wisnua.starterproject.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wisnua.starterproject.domain.model.Article
import com.wisnua.starterproject.domain.repository.NewsRepository

class NewsPagingSource(private val newsRepository: NewsRepository) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1 // Initial page number
            val response = newsRepository.getTopNews(page, params.loadSize,"id")
            LoadResult.Page(
                data = response.articles,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.articles.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        // Return the key used for refreshing the data source
        // This can be based on the current position of the user, for example
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }    }
}
