package com.example.rickandmortyapp.components.retrofit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.data.data_classes.retrofit_data_classes.Character
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R

@Composable
fun ExploreCharacterItem(character: Character) {

    val paddingModifier = Modifier
        .padding(8.dp)

    Column(modifier = Modifier
        .padding(16.dp)
        .background(Color(103, 190, 160))
        .fillMaxWidth()
        .border(
            BorderStroke(
                1.dp,
                Brush.linearGradient(colors = listOf(Color.Black, Color.White))
            )
        ),
        horizontalAlignment = Alignment.Start
    ) {

        Text(modifier = paddingModifier, text = character.name)

        Text(modifier = paddingModifier, text = "Status: ${character.status}")
        Text(modifier = paddingModifier, text = "Species: ${character.species}")

        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            placeholder = painterResource(id = R.drawable.ufo_4778062_640),
            modifier = Modifier.padding(8.dp)
        )
    }
}