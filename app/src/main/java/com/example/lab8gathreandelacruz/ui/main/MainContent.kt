package com.example.lab8gathreandelacruz.ui.main

import android.telecom.Call
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Info
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.lang.Long.toHexString

data class ColorItem(val code: Long, val color: Color)

enum class Screen(val route: String) {
    HOME("home"),
    INFO("info")
}


// Have to add implementation("androidx.navigation:navigation-compose:2.7.5") to build.gradle.kts dependencies
// for this to work

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {

    // The nav controller that will be used to navigate between screens
    val navController = rememberNavController()

    // The state that will be passed to the top bar
    val clickedColor = remember { mutableStateOf<ColorItem?>(null) }

    // Main layout of the app
    Scaffold(
        topBar = {
            MyTopBar(
                navController = navController,
                selectedColor = clickedColor.value
            )
        }
    ) {
        // The navigation host composable, which will navigate between screens
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.HOME.route,

            // The routes that will be navigated to by the nav controller
            builder = {
                // The home screen
                composable(Screen.HOME.route) {
                    Home(navController, clickedColor)
                }

                //
                composable(
                    "info/{code}"
                ) {
                    val colorCode = it.arguments?.getString("code")
                    Info(code = colorCode!!.toLong())
                }
            }
        )
    }
}