package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.booksapp.data.BookDetailData
import com.example.booksapp.ui.BookDetailsTestTags

@Composable
fun BookDetailsDescription(modifier: Modifier = Modifier, bookDetailData: BookDetailData) {
    val paragraphs = bookDetailData.description.split("\n").filter { it.isNotBlank() }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = bookDetailData.title.uppercase(),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
                .padding(horizontal = 16.dp)
                .testTag(BookDetailsTestTags.BookTitleTestTag)
        )
        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = bookDetailData.author,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
                .padding(horizontal = 16.dp)
                .testTag(BookDetailsTestTags.BookAuthorTestTag)
        )
        Spacer(modifier = Modifier.size(24.dp))
        for (paragraph in paragraphs) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = paragraph,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                )
                if (paragraph != paragraphs[paragraphs.size - 1]) {
                    val density = LocalDensity.current
                    val spacingPx = 8f
                    val spacingDp = with(density) { spacingPx.toDp() }
                    Spacer(modifier = Modifier.height(spacingDp))
                }
            }
        }
    }


}


