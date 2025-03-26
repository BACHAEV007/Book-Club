package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.booksapp.R

@Composable
fun StagesContent(
    stage: String,
    modifier: Modifier = Modifier,
    haveRead: Boolean = false,
    current: Boolean = false
) {
    Row(modifier = modifier.padding(vertical = 12.dp)) {
        Text(
            text = stage,
            style = if (current) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(16.dp))
        if (haveRead) {
            Icon(
                painter = painterResource(R.drawable.read),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        } else if (current) {
            Icon(
                painter = painterResource(R.drawable.reading_now),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}