package com.example.lab8gathreandelacruz.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavController, selectedColor: ColorItem?) {
    // This is the top app bar of the Colors screen
    CenterAlignedTopAppBar(

        // The title of the top app bar
        title = {
            Text(text = "Colors", fontSize = 30.sp)
        },

        // The navigation icon of the top app bar
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate("home")
            }) {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = null
                )
            }
        },

        // The actions of the top app bar
        actions = {
            selectedColor?.let {
                Icon(
                    Icons.Outlined.Star,
                    tint = it.color,
                    contentDescription = null
                )
            }
        }
    )
}