package com.example.rickandmortyapp.data.data_classes.room_data_classes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rickandmorty(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // "seed" for id
    val name: String,
    val origin: String,
    val location: String,
    val locationType: String,
    val dimension: String
)
