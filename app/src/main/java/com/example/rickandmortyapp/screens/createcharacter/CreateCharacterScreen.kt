package com.example.rickandmortyapp.screens.createcharacter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.components.HeaderComposable
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty

@Composable
fun CreateCharacterScreen(createCharacterViewModel: CreateCharacterViewModel) {

    var name by remember {
        mutableStateOf("")
    }
    var origin by remember {
        mutableStateOf("")
    }
    var location by remember {
        mutableStateOf("")
    }
    var locationtype by remember {
        mutableStateOf("")
    }
    var dimension by remember {
        mutableStateOf("")
    }
    var addedCharacterName by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        createCharacterViewModel.setCreatedCharacters()
    }

    // Grensesnittet:

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(137, 191, 200))
        .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val createHeadline = "Create your own character"
        HeaderComposable(headline = createHeadline)

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            TextField(value = name,
                onValueChange = {name = it},
                label = { Text(text = "Name")}
            )
            TextField(value = origin,
                onValueChange = {origin = it},
                label = { Text(text = "Origin")}
            )
            TextField(value = location,
                onValueChange = {location = it},
                label = { Text(text = "Present location")}
            )
            TextField(value = locationtype,
                onValueChange = {locationtype = it},
                label = { Text(text = "Type of location")}
            )
            TextField(value = dimension,
                onValueChange = {dimension = it},
                label = { Text(text = "Dimension")}
            )
            Button(onClick = {
                if (name.isNotBlank()){
                    val newCharacter = Rickandmorty(name = name, origin = origin, location = location,
                        locationType = locationtype, dimension = dimension)
                    createCharacterViewModel.insertNewCharacter(newCharacter)
                    addedCharacterName = newCharacter.name
                    message = false
                } else{
                    message = true
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(103, 190, 105)
                )

            ) {
                Text(fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(23, 26, 74),
                    text = "Save character")
            }   // slutt knapp

            if(addedCharacterName.isNotEmpty()){
                Text(text = "${addedCharacterName} was added!")
            }
            if (message) {
                Text(text = "Please add at least a name!")
            }
        }// slutt kolonne for input
    }
}