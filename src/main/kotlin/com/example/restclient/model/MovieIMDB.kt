package com.example.restclient.model

data class MovieIMDB(
    val Response: String,
    val Search: List<Search>?,
    val totalResults: String?,
    val Error: String?
)