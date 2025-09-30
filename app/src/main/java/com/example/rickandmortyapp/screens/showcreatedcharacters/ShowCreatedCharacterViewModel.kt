package com.example.rickandmortyapp.screens.showcreatedcharacters

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty
import com.example.rickandmortyapp.data.room.RickandmortyRepository
import kotlinx.coroutines.flow.MutableStateFlow

class ShowCreatedCharacterViewModel : ViewModel() {

    private val _createdCharacterRepository : RickandmortyRepository = RickandmortyRepository

    val characters = MutableStateFlow<List<Rickandmorty>>(emptyList())

    // Funksjon til hente alle karakterene brukeren har laget
    suspend fun loadCharacters() {
        characters.value = _createdCharacterRepository.getAllCharacters()
    }
}