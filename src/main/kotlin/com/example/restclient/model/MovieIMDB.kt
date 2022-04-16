package com.example.restclient.model

data class MovieIMDB(
    val Response: String,
    val Search: List<Search>? = emptyList(),
    val totalResults: String?,
    val Error: String?
)