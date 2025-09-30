package com.example.rickandmortyapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty

@Database(
    entities = [Rickandmorty::class],
    version = 1,
    exportSchema = false
)
abstract class RickandmortyDatabase : RoomDatabase() {
    abstract fun rickandmortyDao() : RickandmortyDao
}