package com.example.brewery.UI.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.brewery.Helpers.visible
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import javax.inject.Singleton

@Composable
fun Main(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val isLoading: Boolean by viewModel.isLoading
    val selectedTab = MainTab.getTabFromResource(viewModel.selectedTab.value)
    val tabs = MainTab.values()

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) {
                ConstraintLayout {
                    val (body, progress) = createRefs()
                    Scaffold(
                        backgroundColor = MaterialTheme.colors.primarySurface,
                        topBar = { MainAppBar() },
                        modifier = Modifier.constrainAs(body) {
                            top.linkTo(parent.top)
                        },
                        bottomBar = {
                            BottomNavigation(
                                backgroundColor = MaterialTheme.colors.background,
                                modifier = Modifier
                                    .navigationBarsHeight(56.dp)
                            ) {
                                tabs.forEach { tab ->
                                    BottomNavigationItem(
                                        icon = { Icons.Filled.Home},
                                        label = {
                                            Text(
                                                text = tab.title,
                                                color = Color.White
                                            )
                                        },
                                        selected = tab == selectedTab,
                                        onClick = { viewModel.selectTab(tab.ordinal) },
                                        selectedContentColor = LocalContentColor.current,
                                        unselectedContentColor = LocalContentColor.current,
                                        modifier = Modifier.navigationBarsPadding()
                                    )
                                }
                            }
                        },
                        content = {Text(text = "Buzi Adam")}
                    )
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

@Preview
@Composable
private fun MainAppBar() {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = Color.Gray,
        modifier = Modifier.height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = "Brewery",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


enum class MainTab(
    val title: String,
) {
    MAIN("Main");

    companion object {
        fun getTabFromResource(tabNum: Int): MainTab {
            return when (tabNum) {
                0 -> MAIN
                else -> MAIN
            }
        }
    }
}

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")
}