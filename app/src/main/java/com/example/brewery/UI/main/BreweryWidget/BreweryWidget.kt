package com.example.brewery.UI.main.BreweryWidget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.brewery.Model.Brewery
import androidx.compose.material.Surface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.NonDisposableHandle.parent
import java.math.RoundingMode

@Composable
fun BreweryWidget(modifier: Modifier = Modifier,
                  brewery: Brewery) {
    Surface(
        modifier = modifier
            .padding(4.dp),
        color = MaterialTheme.colors.onBackground,
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Row {

                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = brewery?.name ?: "",
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}