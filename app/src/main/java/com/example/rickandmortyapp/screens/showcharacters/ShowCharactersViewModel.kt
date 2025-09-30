package com.example.rickandmortyapp.screens.showcharacters

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.services.CharacterRepository
import com.example.rickandmortyapp.data.data_classes.retrofit_data_classes.Character
import kotlinx.coroutines.flow.MutableStateFlow

class ShowCharactersViewModel : ViewModel() {
    // Kobler opp til repository:
    private val _characterRepository : CharacterRepository = CharacterRepository

    // State, dynamisk, oppdaterer Screen hvis endringer på state:
    val characters = MutableStateFlow<List<Character>>(emptyList())

    suspend fun loadCharacters(){
            characters.value = _characterRepository.fetchAllCharacters()
    }
}