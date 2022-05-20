package com.example.brewery.UI.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.brewery.Model.Brewery

@Composable
fun BreweryItem(modifier: Modifier = Modifier,
            brewery: Brewery
) {
    Surface(
        modifier = modifier
            .padding(4.dp),
        color = Color.LightGray,
        elevation = 4.dp,
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(horizontalAlignment = Alignment.Start){
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.name ?: "",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
            }
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.country ?: "",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
            }
        }
    }
}