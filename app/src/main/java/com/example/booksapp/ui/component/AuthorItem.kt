package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.data.Author

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AuthorItem(modifier: Modifier = Modifier, author: Author, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )
        {
            GlideImage(
                model = author.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(size = 40.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = author.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.primary
            )

        }
    }
}

@Preview
@Composable
fun AuthorItemPreview() {
    AuthorItem(
        author = Author(
            imageUrl = "https://s3-alpha-sig.figma.com/img/fc2f/2f1c/898bdf2cb5cf0120237adce81ea30a40?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=YF3zF9Rv6YP1nFyFtFQALFhmqBE0y3zT4DY2F6Pc-aGpgTaIDegwQcYlA0I2e8-U3MAsIQi5ZM7gZ0kf0JLGZWXOuzFnVJsWQzn4qdg7OjMjV4ArNS40eNVzGWurnJQUI7uXqMwRvkYRm1raLtHkaXK-EkpAEx5lTBvvjxhpmlEFZW~qy1Fbc4W~od-i~5KlPObbA78GzeN1Rxl22UtufuyC0Ei24xdX53J8inrrshLSZmPJ8hxJdwlWyhBfGfMim7UZBGoQrJAJuZ4XvE5jgZqfplNzfaqheYenxiWz5d6O283UXw1ZaH2dV3atPRvqp8aNPMSTpwGaNeTMzX-Y3w__",
            name = "Дэн Браун"
        ), onClick = {}
    )
}