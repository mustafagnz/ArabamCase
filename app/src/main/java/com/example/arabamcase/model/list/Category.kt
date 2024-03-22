package com.example.arabamcase.model.list

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Category(
    val id: Int,
    val name: String
)
