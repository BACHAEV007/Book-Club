package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booksapp.R

@Composable
fun BookDetailProlonged(modifier: Modifier = Modifier, percent: Float) {
    Column (modifier = modifier){
        Text(
            text = stringResource(R.string.have_read).uppercase(),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        CustomStatusBar(
            modifier = Modifier.padding(top = 8.dp),
            percent = percent,

        )
    }

}