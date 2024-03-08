package com.wisnua.begginingproject.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wisnua.begginingproject.domain.model.Article
import com.wisnua.begginingproject.domain.repository.NewsRepository
import com.wisnua.begginingproject.utils.NewsPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    val articles: Flow<PagingData<Article>> = Pager(PagingConfig(pageSize = PAGE_SIZE)) {
        NewsPagingSource(newsRepository)
    }.flow

    private companion object {
        const val PAGE_SIZE = 10
    }
}
