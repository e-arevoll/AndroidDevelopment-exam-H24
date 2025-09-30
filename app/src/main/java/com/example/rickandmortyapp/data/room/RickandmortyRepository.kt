package com.example.rickandmortyapp.data.room

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty
import java.sql.SQLException

object RickandmortyRepository {
    // "Promise" om at databasen kommer til å bli dannet på et senere tidspunkt
    private lateinit var _rickandmortyDatabase : RickandmortyDatabase
    private val _rickandmortyDao by lazy { _rickandmortyDatabase.rickandmortyDao() }

    // Definerer og oppretter databasen
    fun initializeDatabase(context: Context) {
        _rickandmortyDatabase = Room.databaseBuilder(
            context,
            RickandmortyDatabase::class.java,
            "rickandmorty-database"
        ).build()
    }

    // Henter ut alle karakterer som er lagret i databasen
    suspend fun getAllCharacters() : List<Rickandmorty> {
        try{
            return _rickandmortyDao.getAllCreatedCharacters()
        }catch (e: SQLException){
            Log.d("Feil i databasen", e.toString())
            return emptyList()
        } catch (e: Exception){
            Log.d("Annen feil", e.toString())
            return emptyList()
        }
    }

    suspend fun createNewCharacter(rickandmorty: Rickandmorty) : Long {
        try {
            return _rickandmortyDao.createNewCharacter(rickandmorty)
        }catch (e: SQLException){
            return -1L
        }
    }
}