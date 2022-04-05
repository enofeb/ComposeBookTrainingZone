package com.enofeb.composebooktraningzone.chapterOne

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ColorPicker(color: MutableState<Color>) {
    val red = color.value.red
    val green = color.value.green
    val blue = color.value.blue
    Column {
        Slider(value = red, onValueChange = {
            color.value = Color(it, green, blue)
        })
        Slider(value = green, onValueChange = {
            color.value = Color(red, it, blue)
        })
        Slider(value = blue, onValueChange = {
            color.value = Color(red, green, it)
        })
    }
}

@Composable
fun ColorScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val color = remember {  mutableStateOf(Color.Magenta) }
        ColorPicker(color = color)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color.value),
            text = "#${color.value.toArgb().toUInt().toString(16)}",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4.merge(
                TextStyle(color = color.value)
            )
        )
    }
}