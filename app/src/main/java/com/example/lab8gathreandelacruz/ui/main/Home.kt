package com.example.lab8gathreandelacruz.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController, clickedColor: MutableState<ColorItem?>) {

    // List of ColorItems
    // Colors posted on Learning Hub
    // ColorItem is a data class that has two properties: code and color
    val list = listOf(
        ColorItem(0xFFF44336, Color(0xFFF44336)),
        ColorItem(0xFFF44336, Color(0xFFF44336)),
        ColorItem(0xFF9C27B0, Color(0xFF9C27B0)),
        ColorItem(0xFF3F51B5, Color(0xFF3F51B5)),
        ColorItem(0xFF2196F3, Color(0xFF2196F3)),
        ColorItem(0xFF009688, Color(0xFF009688)),
        ColorItem(0xFF4CAF50, Color(0xFF4CAF50)),
        ColorItem(0xFFFFEB3B, Color(0xFFFFEB3B)),
    )

    // Convert list to mutable state list
    val stateList = remember {
        list.toMutableStateList()
    }

    // LazyColumn is a vertically scrolling list that only composes
    // and lays out the currently visible items.
    LazyColumn(content = {
        items(stateList.size) {
            ColorRow(color = stateList[it], navController, clickedColor)
        }
    })
}

@Composable
fun ColorRow(
    color: ColorItem,
    navController: NavController,
    clickedColor: MutableState<ColorItem?>
) {
    // Row is a composable that places its children in a horizontal sequence.
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .clickable { clickedColor.value = color }
        .background(color.color)
        .height(100.dp),
        horizontalArrangement = Arrangement.End
    ) {
        // IconButton is a composable that is a button with an icon.
        IconButton(
            onClick = {
                navController.navigate("info/${color.code}")
            }
        ) {
            // Icon is a composable that displays a vector graphic
            Icon(
                Icons.Outlined.Info,
                contentDescription = null
            )
        }
    }
}