package com.example.booksapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.Book
import com.example.booksapp.data.bookList
import com.example.booksapp.ui.component.BookLibraryItem
import com.example.booksapp.ui.component.LibraryCarousel

@Composable
fun LibraryScreenContent(
    modifier: Modifier = Modifier,
    onBookClick: () -> Unit,
    bookList: List<Book> = com.example.booksapp.data.bookList
) {

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
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.testTag(LibraryTestTags.LibraryTitleTestTag)
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(
                text = stringResource(R.string.new_books).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .testTag(LibraryTestTags.NewBooksTitleTestTag)
            )
        }
        item(span = { GridItemSpan(3) }) {
            LibraryCarousel(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag(LibraryTestTags.LibraryCarouselTestTag),
                bookList
            )
        }
        item(span = { GridItemSpan(3) }) {
            Text(
                text = stringResource(R.string.popular_books).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .testTag(LibraryTestTags.PopularBooksTitleTestTag)
            )
        }
        itemsIndexed(bookList) { index, book ->
            BookLibraryItem(
                modifier = Modifier.testTag("${LibraryTestTags.BookItemTestTagPrefix}$index"),
                book,
                onBookClick,
                index
            )
        }
        item(span = { GridItemSpan(3) }) {
            Spacer(modifier = Modifier.size(80.dp))
        }
    }

}
