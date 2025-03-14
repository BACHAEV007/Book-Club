package com.example.booksapp.ui.component

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.booksapp.R
import com.example.booksapp.data.bookList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BooksCarousel(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val infiniteList = remember { bookList + bookList }

    LaunchedEffect(Unit) {
        while (true) {
            lazyListState.scrollBy(SCROLL_DX)
            delay(DELAY_BETWEEN_SCROLL_MS)

            if (lazyListState.firstVisibleItemIndex >= bookList.size) {
                coroutineScope.launch {
                    lazyListState.scrollToItem(lazyListState.firstVisibleItemIndex - bookList.size)
                }
            }
        }
    }
    if (lazyListState.layoutInfo.visibleItemsInfo.size <= MINIMUM_IMAGES_CAROUSEL){
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
                ) {
                    it.placeholder(R.drawable.cross_icon)
                }
            }
        }
    }
}

private const val DELAY_BETWEEN_SCROLL_MS = 8L
private const val SCROLL_DX = 1f
private const val MINIMUM_IMAGES_CAROUSEL = 6

@Preview
@Composable
fun BooksCarouselPreview() {
    BooksCarousel()
}