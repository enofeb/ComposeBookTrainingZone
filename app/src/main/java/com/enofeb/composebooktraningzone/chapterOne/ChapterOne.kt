package com.enofeb.composebooktraningzone.chapterOne

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.enofeb.composebooktraningzone.R
import com.enofeb.composebooktraningzone.ui.theme.ComposeBookTraningZoneTheme


@Composable
fun Welcome() {
    Text(
        text = stringResource(id = R.string.label_welcome),
        style = MaterialTheme.typography.subtitle1
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBookTraningZoneTheme {
        Welcome()
    }
}