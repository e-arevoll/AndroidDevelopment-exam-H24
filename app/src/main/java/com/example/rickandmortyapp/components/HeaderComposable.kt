package com.example.rickandmortyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R

@Composable
fun HeaderComposable(headline: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.ufo_4778062_640),
            contentDescription = "Ufo"
        )
        Text(fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            text = headline
        )
        Image(
            painter = painterResource(id = R.drawable.ufoborder),
            contentDescription = "" // Kun border, har ingen betydning for funksjonalitet av siden.
        )
    }
    Spacer(modifier = Modifier.size(8.dp))
}