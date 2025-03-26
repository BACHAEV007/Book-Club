package com.example.booksapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.BookDetailData
import com.example.booksapp.data.detailsData
import com.example.booksapp.ui.component.BookDetailHeader
import com.example.booksapp.ui.component.BookDetailProlonged
import com.example.booksapp.ui.component.BookDetailsDescription
import com.example.booksapp.ui.component.StagesContent

@Composable
fun BookDetailsContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onStageClick: (Int) -> Unit,
    topBarPadding: Dp,
    detailsData: BookDetailData = com.example.booksapp.data.detailsData
) {
    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        lazyListState,
    ) {
        item {
            BookDetailHeader(
                onBackClick = onBackClick,
                onReadClick = { onStageClick(detailsData.currentStageIndex) },
                onFavoriteClick = { },
                modifier = Modifier
                    .testTag(BookDetailsTestTags.BookDetailHeaderTestTag)
                    .graphicsLayer {
                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                        translationY = scrolledY * 0.5f
                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                    },
                image = detailsData.image,
                topBarPadding = topBarPadding
            )
        }
        item {
            Spacer(modifier = Modifier.size(24.dp))
        }
        item {
            BookDetailsDescription(
                modifier = Modifier.testTag(BookDetailsTestTags.BookDetailsDescriptionTestTag),
                detailsData
            )
        }
        item {
            Spacer(modifier = Modifier.size(24.dp))
        }
        if (detailsData.percent != 0f) {
            item {
                BookDetailProlonged(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .testTag(BookDetailsTestTags.BookDetailProlongedTestTag),
                    percent = detailsData.percent
                )
            }
            item {
                Spacer(modifier = Modifier.size(24.dp))
            }
        }
        item {
            Text(
                text = stringResource(R.string.tables).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .testTag(BookDetailsTestTags.TablesTitleTestTag)
            )
        }
        item {
            Spacer(modifier = Modifier.size(8.dp))
        }
        itemsIndexed(detailsData.stages) { index, stage ->
            StagesContent(
                stage = stage.name,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .testTag("${BookDetailsTestTags.StageItemTestTagPrefix}$index"),
                haveRead = stage.isRead,
                current = (index == detailsData.currentStageIndex)
            )
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

