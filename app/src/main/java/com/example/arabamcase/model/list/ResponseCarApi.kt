package com.example.arabamcase.model.list

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseCarApi(
    val results: List<Advert>

)
