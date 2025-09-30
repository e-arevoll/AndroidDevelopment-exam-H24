package com.example.rickandmortyapp.data.data_classes.retrofit_data_classes

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)