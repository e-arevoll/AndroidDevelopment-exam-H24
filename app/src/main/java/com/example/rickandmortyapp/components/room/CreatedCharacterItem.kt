package com.example.rickandmortyapp.components.room

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.data.data_classes.room_data_classes.Rickandmorty

@Composable
fun CreatedCharacterItem(rickandmorty: Rickandmorty) {
    Column(modifier = Modifier
        .padding(16.dp)
        .background(Color(103, 190, 160))
        .fillMaxWidth()
        .border(
            BorderStroke(
                1.dp,
                Brush.linearGradient(colors = listOf(Color.Black, Color.White)))
        )
        .padding(8.dp)
    )
    {
        Text(fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            text = rickandmorty.name)
        Text(text="Origin: ${rickandmorty.origin}")
        Text("Location: ${rickandmorty.location}. Type ${rickandmorty.locationType},")
        Text("Dimension: ${rickandmorty.dimension}")
    }
}