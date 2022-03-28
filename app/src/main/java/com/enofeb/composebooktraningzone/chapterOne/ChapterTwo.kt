package com.enofeb.composebooktraningzone.chapterOne

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enofeb.composebooktraningzone.ui.theme.ComposeBookTraningZoneTheme

@Composable
fun Factorial() {
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(factorialAsString(0)) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = text,
            modifier = Modifier.clickable {
                expanded = true
            },
            style = MaterialTheme.typography.h2
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            for (n in 0 until 10) {
                DropdownMenuItem(onClick = {
                    expanded = false
                    text = factorialAsString(n)
                }) {
                    Text(text = "${n.toString()}!")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChapterTwoPreview() {
    ComposeBookTraningZoneTheme {
        Factorial()
    }
}

fun factorialAsString(n: Int): String {
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return "$n! = $result"
}