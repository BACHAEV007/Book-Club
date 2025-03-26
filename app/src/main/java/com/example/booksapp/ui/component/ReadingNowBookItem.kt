package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.R
import com.example.booksapp.data.Book
import com.example.booksapp.ui.BookmarksTestTags

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ReadingNowBookItem(modifier: Modifier = Modifier, book: Book, percent: Float, stage: String) {
    Row(modifier = modifier.fillMaxWidth()) {
        GlideImage(
            model = book.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .weight(0.28f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(size = 4.dp))
                .testTag(BookmarksTestTags.ReadingNowBookImageTestTag),
            contentScale = ContentScale.Fit
        ) {
            it.placeholder(R.drawable.cross_icon)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = book.title.uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.testTag(BookmarksTestTags.ReadingNowBookTitleTestTag)
            )
            Text(
                text = stage,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.testTag(BookmarksTestTags.ReadingNowBookStageTestTag)
            )
            if (percent != 0f) {
                CustomStatusBar(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .testTag(BookmarksTestTags.ReadingNowProgressBarTestTag),
                    percent = percent
                )
            }

        }
    }
}

