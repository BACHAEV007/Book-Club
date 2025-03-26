package com.example.booksapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.Book
import com.example.booksapp.data.Quote
import com.example.booksapp.data.bookList
import com.example.booksapp.data.detailsData
import com.example.booksapp.data.quoteList
import com.example.booksapp.screen.BookmarksScreen
import com.example.booksapp.ui.component.QuoteItem
import com.example.booksapp.ui.component.ReadingNowBookItem
import com.example.booksapp.ui.component.ReadingNowRow
import com.example.booksapp.ui.component.SearchBookItem

@Composable
fun BookmarksScreenContent(
    modifier: Modifier = Modifier,
    onBookClick: () -> Unit,
    onReadNowClick: () -> Unit,
    bookList: List<Book> = com.example.booksapp.data.bookList,
    quoteList: List<Quote> = com.example.booksapp.data.quoteList
) {
    LazyColumn(
        modifier = modifier.padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.bookmarks).uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.testTag(BookmarksTestTags.BookmarksTitleTestTag)
            )
        }
        item {
            ReadingNowRow(
                modifier = Modifier.testTag(BookmarksTestTags.ReadingNowRowTestTag),
                onClick = onReadNowClick
            )
        }
        if (bookList.isNotEmpty()){
            itemsIndexed(bookList.subList(0, 1)) { index, book ->
                ReadingNowBookItem(
                    modifier = Modifier.testTag(BookmarksTestTags.ReadingNowBookItemTestTag),
                    book = book,
                    percent = detailsData.percent,
                    stage = detailsData.stages[detailsData.currentStageIndex].name
                )
            }
        }
        item {
            Text(
                text = stringResource(R.string.favorites_books).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .testTag(BookmarksTestTags.FavoritesBooksTitleTestTag)
            )
        }
        if (bookList.isNotEmpty()){
            itemsIndexed(bookList.subList(0, bookList.size - 1)) { index, book ->
                SearchBookItem(
                    modifier = Modifier.testTag("${BookmarksTestTags.SearchBookItemTestTagPrefix}$index"),
                    book = book,
                    onBookClick = onBookClick
                )
            }
        }

        item {
            Text(
                text = stringResource(R.string.Quotes).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .testTag(BookmarksTestTags.QuotesTitleTestTag)
            )
        }
        itemsIndexed(quoteList) { index, quote ->
            QuoteItem(
                modifier = Modifier.testTag("${BookmarksTestTags.QuoteItemTestTagPrefix}$index"),
                quote = quote
            )
        }
        item {
            Spacer(modifier = Modifier.size(88.dp))
        }
    }
}

@Preview
@Composable
fun BookmarksScreenContentPreview() {
    BookmarksScreenContent(onBookClick = {}, onReadNowClick = {})
}