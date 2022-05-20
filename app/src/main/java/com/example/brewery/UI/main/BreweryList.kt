package com.example.brewery.UI.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brewery.Model.Brewery
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun BreweryList(
    modifier: Modifier = Modifier,
    breweries: List<Brewery>,
    onClick: (brewery: Brewery) -> Unit,
    onDelete: (brewery: Brewery) -> Unit,
    onNameClicked: (brewery: Brewery) -> Unit,
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
                    Column(horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)) {
                        Button(
                            onClick = { onNameClicked(brewery) },
                            Modifier.align(Alignment.End)
                        )
                        {
                            Icon(
                                Icons.Filled.Book,
                                contentDescription = "Details",
                                modifier = Modifier.size(ButtonDefaults.IconSize),
                            )
                        }
                        Button(
                            onClick = { onClick(brewery) },
                            Modifier.align(Alignment.End)
                        )
                        {
                            Icon(
                                Icons.Filled.Edit,
                                contentDescription = "Edit",
                                modifier = Modifier.size(ButtonDefaults.IconSize),
                            )
                        }
                        Button(
                            onClick = { onDelete(brewery) })
                        {
                            Icon(
                                Icons.Filled.Delete,
                                contentDescription = "Delete",
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                        }
                    }
                }
            }
        }
    }
}