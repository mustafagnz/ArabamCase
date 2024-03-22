package com.example.arabamcase.repository

import com.example.arabamcase.api.ApiService
import javax.inject.Inject

class AdvertRepository

@Inject
constructor(private val api: ApiService){
    suspend fun getListAdvert(filter : Int) = api.getCarList()
}



