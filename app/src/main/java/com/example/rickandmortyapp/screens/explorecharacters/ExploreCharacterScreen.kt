package com.example.rickandmortyapp.screens.explorecharacters

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.components.HeaderComposable
import com.example.rickandmortyapp.components.retrofit.ExploreCharacterItem

@Composable
fun ExploreCharacterScreen(exploreCharacterViewmodel: ExploreCharacterViewModel){
    var inputText by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf(false)
    }
    val searchedCharacter by exploreCharacterViewmodel.searchedCharacter.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(137, 191, 200))
        .padding(12.dp)
    ){
        
        val headline = "Explore characters"
        HeaderComposable(headline = headline)

        Column(modifier = Modifier.align(Alignment. CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally){

            val focusManager = LocalFocusManager.current
            TextField(
                value = inputText,
                onValueChange = {
                inputText = it
            },
                label={ Text(text = "Name, ex. Rick Sanchez")
                },
                // Legger til "Done"-knapp til tastaturet på mobilen
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                })
            )
            Button(onClick = {
                if (inputText.isNotBlank()) {
                    Log.d("CharacterSearched", "Searching for: $inputText")
                    exploreCharacterViewmodel.setSearchedCharacter(inputText)
                    message = false
                } else {
                    message = true
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(103, 190, 105))
            ) {
                Text(fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(23, 26, 74),
                    text = "Search")
            }

        } // slutt søkefelt-kolonne

            if(message) {
                Text(text = "Please write a name in the textbox to begin the exploration!")
            }
            // Mellomrom mellom komponentene
            Spacer(modifier = Modifier.size(8.dp))

            // Kolonne for utskrift av detaljer
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
                ){
                LazyColumn{
                    items(searchedCharacter) { character ->
                        ExploreCharacterItem(character = character)
                    }
                }
            } // slutt kolonne
    } // slutt hovedkolonne
}


