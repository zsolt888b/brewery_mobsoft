package com.example.brewery.UI.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.brewery.Helpers.visible
import com.example.brewery.Model.Brewery
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import javax.inject.Singleton

@Composable
fun Main(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val isLoading: Boolean by viewModel.isLoading
    val selectedTab = Tabs.getTabFromResource(viewModel.selectedTab.value)

    val breweries by viewModel.breweryList.collectAsState(initial = listOf())

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) {
                ConstraintLayout {
                    val (body, progress) = createRefs()
                    Scaffold(
                        backgroundColor = Color.White,
                        topBar = { MainAppBar(viewModel.title.value,
                            viewModel.showAddButton.value,
                            viewModel.showBackButton.value,
                            viewModel.showSaveButton.value,
                            { _ -> viewModel.backClicked(0)},
                            { _ -> viewModel.addClicked((2))},
                            { _ -> viewModel.saveClicked(0)}) },
                        modifier = Modifier.constrainAs(body) {
                            top.linkTo(parent.top)
                        }
                    ){innerPadding ->
                        val modifier = Modifier.padding(innerPadding)
                        Crossfade(selectedTab) { destination ->
                            when (destination) {
                                Tabs.MAIN -> BreweryList(modifier, breweries ?: listOf(), {brewery -> viewModel.selectBrewery(2, brewery)}
                                , {brewery -> viewModel.delete(brewery)},
                                    {brewery -> viewModel.selectBrewery(1, brewery)})
                                Tabs.DETAILS -> BreweryDetails(modifier,viewModel.selectedBrewery.value)
                                Tabs.ADDOREDIT -> BreweryAddOrEdit(modifier, viewModel.selectedBrewery.value)
                            }
                        }
                    }
                    CircularProgressIndicator(
                        modifier = Modifier
                            .constrainAs(progress) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .visible(isLoading)
                    )
                }
            }
        }
    }
}

@Composable
private fun MainAppBar(name : String, showAddButoon : Boolean,
                       showBackButton : Boolean,
                       showSaveButton : Boolean,
                       onBackClicked: (any : Any?) -> Unit,
                       onAddClicked: (any : Any?) -> Unit,
                       onSaveClicked: (any : Any?) -> Unit) {
    if(showAddButoon){
        TopAppBar(
            elevation = 6.dp,
            backgroundColor = MaterialTheme.colors.primarySurface,
            modifier = Modifier.height(58.dp),
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = name,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = { onAddClicked(null) })
            {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
    if(showBackButton){
        TopAppBar(
            elevation = 6.dp,
            backgroundColor = MaterialTheme.colors.primarySurface,
            modifier = Modifier.height(58.dp),
        ) {
            Button(
                onClick = { onBackClicked(null) })
            {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(ButtonDefaults.IconSize))
            }
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = name,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    if(showSaveButton && showBackButton){
        TopAppBar(
            elevation = 6.dp,
            backgroundColor = MaterialTheme.colors.primarySurface,
            modifier = Modifier.height(58.dp),
        ) {
            Button(
                onClick = { onBackClicked(null) })
            {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(ButtonDefaults.IconSize))
            }
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = name,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = { onSaveClicked(0) })
            {
                Icon(
                    Icons.Filled.Save,
                    contentDescription = "Save",
                    modifier = Modifier.size(ButtonDefaults.IconSize))
            }
        }
    }

}


enum class Tabs(
    val title: String,
) {
    MAIN("Main"), DETAILS("Details"), ADDOREDIT("AddOrEdit");

    companion object {
        fun getTabFromResource(tab: Int): Tabs {
            return when (tab) {
                0 -> MAIN
                1 -> DETAILS
                2 -> ADDOREDIT
                else -> MAIN
            }
        }
    }
}

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")
}