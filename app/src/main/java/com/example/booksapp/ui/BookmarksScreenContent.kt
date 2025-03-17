package com.example.booksapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.bookList
import com.example.booksapp.data.quoteList
import com.example.booksapp.screen.BookmarksScreen
import com.example.booksapp.ui.component.QuoteItem
import com.example.booksapp.ui.component.ReadingNowBookItem
import com.example.booksapp.ui.component.ReadingNowRow
import com.example.booksapp.ui.component.SearchBookItem

@Composable
fun BookmarksScreenContent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item {
            Text(
                text = stringResource(R.string.bookmarks).uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        item {
            ReadingNowRow(modifier = Modifier, onClick = {})
        }
        items(bookList.subList(4, 5)) {
            ReadingNowBookItem(modifier = Modifier, it)
        }
        item {
            Text(
                text = stringResource(R.string.favorites_books).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }
        items(bookList.subList(2, 5)) {
            SearchBookItem(modifier = Modifier, it)
        }
        item {
            Text(
                text = stringResource(R.string.Quotes).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }
        items(quoteList) {
            QuoteItem(modifier = Modifier, it)
        }
    }
}

@Preview
@Composable
fun BookmarksScreenContentPreview(){
    BookmarksScreenContent()
}