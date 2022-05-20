package com.example.brewery.UI.main

import android.media.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
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
fun BreweryDetails (modifier: Modifier = Modifier,
                    brewery: Brewery
){
    Surface(
        modifier = modifier
            .padding(4.dp),
        elevation = 4.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text =  "City: ",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.city ?: "<unavailable>",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Right,
                )
            }
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text =  "Country: ",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.country ?: "<unavailable>",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Right,
                )
            }
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text =  "Type: ",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.brewery_type ?: "<unavailable>",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Right,
                )
            }
            Divider(color = Color.Black, thickness = 5.dp)
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text =  "Street: ",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.street ?: "<unavailable>",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Right,
                )
            }
            Divider(color = Color.Black, thickness = 5.dp)
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text =  "State: ",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.state ?: "<unavailable>",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Right,
                )
            }
            Divider(color = Color.Black, thickness = 5.dp)
            Row {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text =  "Postal Code: ",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Left,
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.postal_code ?: "<unavailable>",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    textAlign = TextAlign.Right,
                )
            }
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}