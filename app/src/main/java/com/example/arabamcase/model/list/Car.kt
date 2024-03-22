package com.example.arabamcase.model.list

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Car(
    val id: Int,
    val title: String,
    val location: Location,
    val category: Category,
    val modelName: String,
    val price: Int,
    val priceFormatted: String,
    val date: String,
    val dateFormatted: String,
    val photo: String,
    val properties: List<Property>
)
