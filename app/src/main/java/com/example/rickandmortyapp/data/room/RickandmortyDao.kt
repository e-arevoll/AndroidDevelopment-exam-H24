package com.example.rickandmortyapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty

@Dao
interface RickandmortyDao {
    // Lese
    @Query("SELECT * FROM Rickandmorty")
    suspend fun getAllCreatedCharacters() : List<Rickandmorty>

    // Skape
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createNewCharacter(rickandmorty: Rickandmorty) : Long
}