package com.example.booksapp.ui.component

import android.net.Uri
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.R
import com.example.booksapp.data.bookList
import com.example.booksapp.ui.adapter.CarouselAdapter
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy
import com.google.android.material.carousel.MaskableFrameLayout
import kotlin.math.abs


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LibraryCarousel(modifier: Modifier = Modifier) {
    var currentItem by remember { mutableStateOf(0) }

    Box(modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            factory = { context ->
                RecyclerView(context).apply {
                    layoutManager = CarouselLayoutManager(HeroCarouselStrategy()).apply {
                        setCarouselAlignment(CarouselLayoutManager.ALIGNMENT_CENTER)
                    }
                    adapter = CarouselAdapter(bookList, mutableStateOf(currentItem))
                    val snapHelper = CarouselSnapHelper()
                    snapHelper.attachToRecyclerView(this)
                    addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            val layoutManager = recyclerView.layoutManager as CarouselLayoutManager
                            val snapView = snapHelper.findSnapView(layoutManager)
                            val snapPosition = snapView?.let { recyclerView.getChildAdapterPosition(it) }
                                ?: RecyclerView.NO_POSITION
                            if (snapPosition != RecyclerView.NO_POSITION) {
                                currentItem = snapPosition
                            }
                        }
                    })
                }
            },
            update = { recyclerView ->
                recyclerView.adapter = CarouselAdapter(bookList, mutableStateOf(currentItem))
            }
        )
    }
}


@Composable
@Preview
fun LibraryCarouselPreview() {
    LibraryCarousel()
}