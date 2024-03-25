package com.example.arabamcase.main.list

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.arabamcase.model.list.Advert
import com.example.arabamcase.paging.AdvertPagingSource
import com.example.arabamcase.repository.AdvertRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
class ListViewModel
@Inject
constructor(
    private val repository: AdvertRepository
): ViewModel() {

    private val _advertList = MutableLiveData<List<Advert>>()
    val advertList: LiveData<List<Advert>> = _advertList

    init {
        viewModelScope.launch{
            loadAdvertList()
        }
    }
    private suspend fun loadAdvertList(){
        try {
            // Repository üzerinden 10 adet ilan listesi getirildi.
            val response = repository.getListAdvert(10)
            val advertList = response.body()?.results ?: emptyList()
            _advertList.value = advertList
        }catch (e: Exception){
            Log.d(TAG, "loadAdvertList: İlanlar yüklenmedi ")
        }
    }

    val listData = Pager(PagingConfig(pageSize = 10)){
        AdvertPagingSource(repository)
    }.flow.cachedIn(viewModelScope)


}