package com.example.rickandmortyapp.screens.createcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty
import com.example.rickandmortyapp.data.room.RickandmortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CreateCharacterViewModel : ViewModel(){
    private val _characters = MutableStateFlow<List<Rickandmorty>>(emptyList())

    fun setCreatedCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            _characters.value = RickandmortyRepository.getAllCharacters()
        }
    }

    fun insertNewCharacter(rickandmorty: Rickandmorty) {
        viewModelScope.launch(Dispatchers.IO) {
            val newCharacterId = RickandmortyRepository.createNewCharacter(rickandmorty)
            if(newCharacterId != -1L) {
                val newCharacter = rickandmorty.copy(newCharacterId.toInt())
                _characters.value += newCharacter
            }
        }
    }


}