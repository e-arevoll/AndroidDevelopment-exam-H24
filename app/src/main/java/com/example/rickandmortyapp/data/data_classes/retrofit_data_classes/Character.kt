package com.example.rickandmortyapp.data.data_classes.retrofit_data_classes

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val origin: Origin,
    val image: String
)
