package com.example.rickandmortyapp.components.retrofit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.data_classes.retrofit_data_classes.Character

@Composable
fun CharacterItem(character: Character) {

    // Hvordan en karakter skal vises i appen:

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color(103, 190, 200))
            .fillMaxSize()
            .border(
                BorderStroke(
                    1.dp,
                    Brush.linearGradient(colors = listOf(Color.Black, Color.White))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){

            Text(
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = "${character.name} ")

            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =
                "Species: ${ character.species }" +
                        "${character.type}")

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                placeholder = painterResource(id = R.drawable.ufo_4778062_640),
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
            )
        }
}