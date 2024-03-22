package com.example.arabamcase.api

import com.example.arabamcase.model.list.ResponseCarApi
import com.example.arabamcase.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.ARABAM_LIST_END_POINT)
    suspend fun getCarList(
    ):Response<ResponseCarApi>


}