package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.rickandmortyapp.ui.theme.RickandMortyAppTheme
import androidx.activity.viewModels
import com.example.rickandmortyapp.data.room.RickandmortyRepository
import com.example.rickandmortyapp.navigation.AppNavigation
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterViewModel
import com.example.rickandmortyapp.screens.explorecharacters.ExploreCharacterViewModel
import com.example.rickandmortyapp.screens.showcharacters.ShowCharactersViewModel
import com.example.rickandmortyapp.screens.showcreatedcharacters.ShowCreatedCharacterViewModel


class MainActivity : ComponentActivity() {

    // Oppretter og initiere viewmodels
    private val _showCharactersViewModel : ShowCharactersViewModel by viewModels()
    private val _exploreCharactersViewModel : ExploreCharacterViewModel by viewModels()
    private val _createCharacterViewModel : CreateCharacterViewModel by viewModels()
    private val _showCreatedCharacterViewModel : ShowCreatedCharacterViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {

        // Initialiserer den lokale databasen
        RickandmortyRepository.initializeDatabase(applicationContext)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickandMortyAppTheme {
                AppNavigation(
                    _showCharactersViewModel,
                    _showCreatedCharacterViewModel,
                    _createCharacterViewModel,
                    _exploreCharactersViewModel)
            }
        }
    }
}
