package com.enofeb.composebooktraningzone.chapters

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enofeb.composebooktraningzone.R
import com.enofeb.composebooktraningzone.ui.theme.ComposeBookTraningZoneTheme


@Composable
fun ChapterOneScreen() {
    GreetingChapter("Enes")
}

@Composable
fun Welcome() {
    Text(
        text = stringResource(id = R.string.label_welcome),
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
fun GreetingChapter(name: String) {
    Text(
        text = stringResource(id = R.string.label_hello, name),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
fun TextAndButtonInRow(name: MutableState<String>, nameEntered: MutableState<Boolean>) {
    Row(modifier = Modifier.padding(8.dp)) {
        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            placeholder = {
                Text(text = stringResource(id = R.string.label_hello))
            },
            modifier = Modifier
                .alignByBaseline()
                .weight(1.0F),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                capitalization = KeyboardCapitalization.Words
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    nameEntered.value = true
                }
            )
        )
    }
}

@Composable
fun ButtonFirst() {
    Button(modifier = Modifier.padding(), onClick = {
        // no logic
    }) {
        Text(text = stringResource(id = R.string.label_welcome))
    }
}

@Composable
fun Hello() {

    val name = remember { mutableStateOf("") }
    val nameEntered = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (nameEntered.value) {
            GreetingChapter(name = name.value)
        } else {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Welcome()
                TextAndButtonInRow(name = name, nameEntered = nameEntered)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBookTraningZoneTheme {
        ButtonFirst()
    }
}

@Preview(group = "welcome")
@Composable
fun WelcomePreview() {
    ComposeBookTraningZoneTheme {
        Welcome()
    }
}