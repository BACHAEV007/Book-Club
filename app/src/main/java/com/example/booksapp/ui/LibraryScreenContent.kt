package com.example.booksapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.bookList
import com.example.booksapp.screen.LibraryScreen
import com.example.booksapp.ui.component.BookLibraryItem
import com.example.booksapp.ui.component.LibraryCarousel

@Composable
fun LibraryScreenContent(modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = { GridItemSpan(3) }) {
            Text(
                text = stringResource(R.string.library).uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(
                text = stringResource(R.string.new_books).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        item(span = { GridItemSpan(3) }) {
            LibraryCarousel(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(
                text = stringResource(R.string.popular_books).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        items(bookList) { book ->
            BookLibraryItem(modifier = Modifier, book)
        }
        item(span = { GridItemSpan(3) }) {
            Spacer(modifier = Modifier.size(80.dp))
        }
    }

}

@Preview
@Composable
fun LibraryScreenContentPreview() {
    LibraryScreenContent()
}