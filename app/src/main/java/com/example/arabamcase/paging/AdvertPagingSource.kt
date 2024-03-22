package com.example.arabamcase.paging

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import com.example.arabamcase.model.list.Advert
import com.example.arabamcase.repository.AdvertRepository

class AdvertPagingSource (
    private val repository: AdvertRepository
): PagingSource<Int, Advert>() {
    override fun getRefreshKey(state: PagingState<Int, Advert>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Advert> {

        return try {
            val currentPage = params.key ?: 1
            val response = repository.getListAdvert(10)
            val responseData = mutableListOf<Advert>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else -1,
                nextKey = currentPage?.plus(1)

            )

        }catch (e: Exception){
            LoadResult.Error(e)
        }

    }
}