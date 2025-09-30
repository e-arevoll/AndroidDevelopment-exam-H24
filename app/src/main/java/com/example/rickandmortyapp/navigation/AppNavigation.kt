package com.example.rickandmortyapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterScreen
import com.example.rickandmortyapp.screens.createcharacter.CreateCharacterViewModel
import com.example.rickandmortyapp.screens.explorecharacters.ExploreCharacterScreen
import com.example.rickandmortyapp.screens.explorecharacters.ExploreCharacterViewModel
import com.example.rickandmortyapp.screens.showcharacters.ShowCharactersScreen
import com.example.rickandmortyapp.screens.showcharacters.ShowCharactersViewModel
import com.example.rickandmortyapp.screens.showcreatedcharacters.ShowCreatedCharacterScreen
import com.example.rickandmortyapp.screens.showcreatedcharacters.ShowCreatedCharacterViewModel
import kotlinx.serialization.Serializable

@Serializable
object Characters   // #1

@Serializable
object ViewCreatedCharacters    // #2

@Serializable
object CreateCharacter   // #3

@Serializable
object ExploreCharacters    // #4

@Composable
fun AppNavigation(showCharactersViewModel: ShowCharactersViewModel,
                  showCreatedCharacterViewModel: ShowCreatedCharacterViewModel,
                  createCharacterViewModel: CreateCharacterViewModel,
                  exploreCharacterViewModel: ExploreCharacterViewModel) {

    // Opprette nav-controller for navigering
    val navController = rememberNavController()

    // currentScreen tar vare på hvilken skjerm man er på
    var currentScreen by remember {
        mutableIntStateOf(0)
    }

    val bottomBarTheme = NavigationBarItemDefaults.colors(
        indicatorColor = Color.Transparent,
        selectedIconColor = Color(12, 75, 77, 255),
        selectedTextColor = Color(12, 75, 77, 255),
        unselectedIconColor = Color(72, 120, 122, 255),
        unselectedTextColor = Color(72, 120, 122, 255),
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color(128, 203, 196, 255)
            ) {
                NavigationBarItem(selected = currentScreen == 0,
                    onClick = { currentScreen = 0
                              navController.navigate(Characters)},
                    icon = {
                        if (currentScreen == 0){
                            Icon(imageVector = Icons.Filled.AccountBox,
                                contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Outlined.AccountBox,
                                contentDescription = null)
                        }
                    },
                    label = {
                        Text(text = "Characters")
                    },
                    colors = bottomBarTheme
                )   // slutt navigationBarItem
                NavigationBarItem(selected = currentScreen == 3,
                    onClick = { currentScreen = 3
                        navController.navigate(ExploreCharacters)},
                    icon = {
                        if (currentScreen == 3){
                            Icon(imageVector = Icons.Filled.Search,
                                contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Outlined.Search,
                                contentDescription = null)
                        }
                    },
                    label = {
                        Text(text = "Search")
                    },
                    colors = bottomBarTheme
                )   // slutt navigationBarItem
                NavigationBarItem(selected = currentScreen == 2,
                    onClick = { currentScreen = 2
                        navController.navigate(CreateCharacter)},
                    icon = {
                        if (currentScreen == 2){
                            Icon(imageVector = Icons.Filled.Build,
                                contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Outlined.Build,
                                contentDescription = null)
                        }
                    },
                    label = {
                        Text(text = "Create")
                    },
                    colors = bottomBarTheme
                )   // slutt navigationBarItem
                NavigationBarItem(selected = currentScreen == 1,
                    onClick = { currentScreen = 1
                        navController.navigate(ViewCreatedCharacters)},
                    icon = {
                        if (currentScreen == 1){
                            Icon(imageVector = Icons.Filled.Person,
                                contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Outlined.Person,
                                contentDescription = null)
                        }
                    },
                    label = {
                        Text(text = "Creations")
                    },
                    colors = bottomBarTheme
                )   // slutt navigationBarItem
            }   // slutt navigationBar
        }   // slutt bottomBar

        ) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ) {
            // Legger inn navhost (endrer hvilken screen som skal vises)
            NavHost(navController = navController,
                startDestination = Characters) {
                composable<Characters> {
                    ShowCharactersScreen(showCharactersViewModel)
                }
                composable<ExploreCharacters> {
                    ExploreCharacterScreen(exploreCharacterViewModel)
                }
                composable<CreateCharacter> {
                    CreateCharacterScreen(createCharacterViewModel)
                }
                composable<ViewCreatedCharacters> {
                    ShowCreatedCharacterScreen(showCreatedCharacterViewModel)
                }
            } // slutt navHost
        }
    }   // slutt scaffold
}