package com.example.brewery.UI.main

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brewery.Model.Brewery
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun BreweryList(
    modifier: Modifier = Modifier,
    breweries: List<Brewery>
){
    LazyColumn {
        items(breweries) { brewery ->
            Column(horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)) {
                Card(
                    modifier = Modifier.padding(2.dp),
                    backgroundColor = Color.Gray
                ) {
                    Column(horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)) {
                        BreweryItem(modifier, brewery)
                    }
                }
            }
        }
    }
}