package com.example.booksapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.R
import com.example.booksapp.data.Book
import com.example.booksapp.ui.LibraryTestTags


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BookLibraryItem(
    modifier: Modifier = Modifier, book: Book, onBookClick: () -> Unit,
    index: Int
) {
    Column(modifier = modifier.clickable { onBookClick() }) {
        GlideImage(
            model = book.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .width(116.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(size = 4.dp))
                .testTag("${LibraryTestTags.BookImageTestTagPrefix}$index"),
            contentScale = ContentScale.Fit
        ) {
            it.placeholder(R.drawable.cross_icon)
        }
        Text(
            text = book.title.uppercase(),
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 14.sp,
            lineHeight = 14.sp,
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = book.author,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(top = 4.dp)
                .testTag("${LibraryTestTags.BookAuthorTestTagPrefix}$index"),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

