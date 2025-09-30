package com.example.rickandmortyapp.screens.showcharacters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rickandmortyapp.components.HeaderComposable
import com.example.rickandmortyapp.components.retrofit.CharacterItem

@Composable
fun ShowCharactersScreen(showCharacterViewModel: ShowCharactersViewModel){

    // LaunchedEffect-metode som kjører viewmodel
    LaunchedEffect(Unit) {
        showCharacterViewModel.loadCharacters()
    }

    // Lokal variabel som kobler seg opp mot karakterene i ViewModel
    val characters = showCharacterViewModel.characters.collectAsState()
    // Generere innhold i en LazyColumn
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(137, 191, 200))
    ) {
        val headline = "Rick & Morty characters"
        HeaderComposable(headline)

        Column (modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(137, 191, 200),
            )
        ){
            LazyColumn{
                items(characters.value) { character ->
                    CharacterItem(character = character)
                }
            }
        }
    }
}