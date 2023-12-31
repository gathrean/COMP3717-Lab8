package com.example.lab8gathreandelacruz.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import java.lang.Long.toHexString

@Composable
fun Info(code: Long?) {
    // Column is a composable that places its children in a vertical sequence.
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(code!!))
    ) {
        // Text is a composable that renders text on the screen.
        Text(text = toHexString(code), fontSize = 30.sp)
    }
}