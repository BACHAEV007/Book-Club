package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.booksapp.data.Book
import com.example.booksapp.ui.adapter.CarouselAdapter
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LibraryCarousel(
    modifier: Modifier = Modifier,
    bookList: List<Book>
) {
    var currentItem by remember { mutableStateOf(0) }

    Box(modifier = modifier) {
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
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
                            val snapPosition =
                                snapView?.let { recyclerView.getChildAdapterPosition(it) }
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

