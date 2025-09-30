package com.example.rickandmortyapp.screens.showcreatedcharacters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.components.HeaderComposable
import com.example.rickandmortyapp.components.room.CreatedCharacterItem

@Composable
fun ShowCreatedCharacterScreen(showCreatedCharacterViewModel: ShowCreatedCharacterViewModel) {
    // Launched effect: Metode som kjører en gang for å få i gang bakgrunnsprosessene (som den del av Coroutine)
    LaunchedEffect(Unit) {
        showCreatedCharacterViewModel.loadCharacters()
    }

    // Lokal variabel som kobler seg mot karakterene i viewmodel
    val characters = showCreatedCharacterViewModel.characters.collectAsState()

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(137, 191, 200))
        .padding(12.dp)
    ){
        val headline = "Your Rick&Morty creations"
        HeaderComposable(headline = headline)

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color(137, 191, 200))
        ) {
            LazyColumn (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(characters.value) { character ->
                    CreatedCharacterItem(rickandmorty = character)
                }
            }
        }
    }
}