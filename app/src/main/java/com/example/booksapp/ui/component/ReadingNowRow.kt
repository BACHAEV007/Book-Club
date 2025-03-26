package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.booksapp.R
import com.example.booksapp.ui.BookmarksTestTags

@Composable
fun ReadingNowRow(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.reading_now).uppercase(),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.testTag(BookmarksTestTags.ReadingNowTitleTestTag)
        )
        IconButton(
            onClick = onClick,
            modifier = Modifier.testTag(BookmarksTestTags.PlayButtonTestTag),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.play_icon),
                contentDescription = null,
            )
        }
    }
}

@Composable
@Preview
fun ReadingNowRowPreview() {
    ReadingNowRow(onClick = {})
}