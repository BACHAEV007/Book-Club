package com.example.booksapp.ui.component

import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.constants.Constants
import com.example.booksapp.data.bookList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BooksCarousel(modifier: Modifier = Modifier, isTesting: Boolean = false) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val shouldRenderLazyRow by remember {
        derivedStateOf {
            lazyListState.layoutInfo.visibleItemsInfo.size <= Constants.MINIMUM_IMAGES_CAROUSEL
        }
    }

    val infiniteList = remember { bookList + bookList }

    LaunchedEffect(Unit) {
        if (isTesting) return@LaunchedEffect
        while (true) {
            lazyListState.scrollBy(Constants.SCROLL_DX)
            delay(Constants.DELAY_BETWEEN_SCROLL_MS)

            if (lazyListState.firstVisibleItemIndex >= bookList.size) {
                coroutineScope.launch {
                    lazyListState.scrollToItem(lazyListState.firstVisibleItemIndex - bookList.size)
                }
            }
        }
    }
    if (shouldRenderLazyRow) {
        LazyRow(
            state = lazyListState,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            userScrollEnabled = false,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(infiniteList) { book ->
                GlideImage(
                    model = book.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(2f / 3f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(size = 4.dp)),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}



@Preview
@Composable
fun BooksCarouselPreview() {
    BooksCarousel()
}