package com.example.brewery.UI.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.brewery.Model.Brewery
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun BreweryAddOrEdit (modifier: Modifier = Modifier, brewery: Brewery){
    var name by rememberSaveable { mutableStateOf(brewery?.name) }
    var city by rememberSaveable { mutableStateOf(brewery?.city) }
    var country by rememberSaveable { mutableStateOf(brewery?.country) }
    var brewery_type by rememberSaveable { mutableStateOf(brewery?.brewery_type) }
    var street by rememberSaveable { mutableStateOf(brewery?.street) }
    var state by rememberSaveable { mutableStateOf(brewery?.state) }
    var postal_code by rememberSaveable { mutableStateOf(brewery?.postal_code) }

    Column(horizontalAlignment = Alignment.End){
        Row (){
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "Name: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = name ?: "New brewery",
                onValueChange = {
                    name = it
                },
            )
        }
        Divider(color = Color.Black, thickness = 5.dp)
        Row {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "City: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = city ?: "",
                onValueChange = {
                    city = it
                },
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
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = country ?: "",
                onValueChange = {
                    country = it
                },
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
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = brewery_type ?: "",
                onValueChange = {
                    brewery_type = it
                },
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
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = street ?: "",
                onValueChange = {
                    street = it
                },
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
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = state ?: "",
                onValueChange = {
                    state = it
                },
            )
        }
        Divider(color = Color.Black, thickness = 5.dp)
        Row {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text =  "P Code: ",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Left,
            )
            TextField(
                modifier = Modifier
                    .padding(2.dp),
                value = postal_code ?: "",
                onValueChange = {
                    postal_code = it
                },
            )
        }
        Divider(color = Color.Black, thickness = 5.dp)
    }
}