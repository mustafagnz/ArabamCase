package com.example.arabamcase.model.list

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Location(
    val cityName: String,
    val townName: String
)
