package com.example.arabamcase.model.list

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Property(
    val name: String,
    val value: String
)
