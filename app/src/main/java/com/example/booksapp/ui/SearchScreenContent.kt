package com.example.booksapp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.R
import com.example.booksapp.data.bookList
import com.example.booksapp.data.searchScreenData
import com.example.booksapp.ui.component.AuthorItem
import com.example.booksapp.ui.component.FilterItem
import com.example.booksapp.ui.component.LastQueryItem
import com.example.booksapp.ui.component.SearchBookItem

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun SearchScreenContent(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = if (!expanded) Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp) else Modifier.fillMaxSize()
    ) {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),

            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { expanded = false },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = {
                        Text(
                            stringResource(R.string.search_books),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    },

                    leadingIcon = {
                        Icon(
                            painter = if (!expanded) painterResource(R.drawable.search_icon) else painterResource(
                                R.drawable.back_search_ic
                            ),
                            contentDescription = null,
                            tint = if (!expanded) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
                            modifier = if (expanded) Modifier.clickable {
                                expanded = false
                            } else Modifier
                        )
                    },
                    trailingIcon = {
                        if (expanded) {
                            Icon(
                                painter = painterResource(R.drawable.cross_icon),
                                contentDescription = null,
                                modifier = Modifier.clickable { text = "" },
                                tint = MaterialTheme.colorScheme.primary
                            )
                        } else null
                    },
                    modifier = if (!expanded) Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(52.dp)
                        )
                        .padding(
                            start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp
                        ) else Modifier.padding(
                        start = 4.dp, end = 4.dp
                    ),
                    colors = TextFieldDefaults.colors().copy(
                        cursorColor = MaterialTheme.colorScheme.onSecondary,
                        focusedTextColor = MaterialTheme.colorScheme.primary,
                        unfocusedTextColor = MaterialTheme.colorScheme.primary,
                        disabledTextColor = MaterialTheme.colorScheme.primary
                    ),


                    )
            },
            colors = SearchBarDefaults.colors(
                containerColor = if (expanded) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.surface,
                dividerColor = MaterialTheme.colorScheme.secondary
            ),
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier)
                }
                items(bookList) { book ->
                    SearchBookItem(modifier = Modifier, book = book)
                }
            }
        }
        if (!expanded) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(top = 126.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = stringResource(R.string.last_query).uppercase(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                items(searchScreenData.filter, span = { GridItemSpan(2) }) {
                    LastQueryItem(query = it)
                }
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = stringResource(R.string.genres).uppercase(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                }

                items(searchScreenData.genres) {
                    FilterItem(modifier = Modifier, text = it)
                }
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = stringResource(R.string.author).uppercase(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                }
                items(searchScreenData.authors, span = { GridItemSpan(2) }) {
                    AuthorItem(author = it)
                }
            }
        }
    }
}





@Preview
@Composable
fun SearchScreenContentPreview() {
    SearchScreenContent()
}