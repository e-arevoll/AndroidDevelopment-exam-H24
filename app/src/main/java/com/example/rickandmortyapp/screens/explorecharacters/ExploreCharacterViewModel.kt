package com.example.rickandmortyapp.screens.explorecharacters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.data_classes.retrofit_data_classes.Character
import com.example.rickandmortyapp.data.services.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExploreCharacterViewModel : ViewModel() {

    private val _searchedCharacter = MutableStateFlow<List<Character>>(emptyList())
    val searchedCharacter = _searchedCharacter.asStateFlow()

    fun setSearchedCharacter(name: String) {
        viewModelScope.launch{
            try{
                _searchedCharacter.value = CharacterRepository.getCharacterByName(name)
            }catch (e: Exception) {
                Log.e("ViewModel", "Error fetching character", e)
                _searchedCharacter.value = emptyList()
            }
        }
    }
}