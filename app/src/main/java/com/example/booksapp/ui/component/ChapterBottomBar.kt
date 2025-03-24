package com.example.booksapp.ui.component

import android.media.Image.Plane
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R

@Composable
fun ChapterBottomBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onStagesClick: () -> Unit,
    onForwardClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onPlayClick: () -> Unit,
    isPlay: Boolean = false
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Icon(
                painter = painterResource(R.drawable.chapter_back_ic),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .clickable(onClick = onBackClick)
            )

            Icon(
                painter = painterResource(R.drawable.stages_ic),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .clickable(onClick = onStagesClick)
            )

            Icon(
                painter = painterResource(R.drawable.chapter_forward_ic),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .clickable(onClick = onForwardClick)
            )


            Icon(
                painter = painterResource(R.drawable.chapter_settings),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .clickable(onClick = onSettingsClick)
            )
        }

        FloatingActionButton(
            onClick = onPlayClick,
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, end = 16.dp),
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
        ) {
            Icon(
                painter = if (isPlay) painterResource(R.drawable.pause_ic) else painterResource(R.drawable.play_icon),
                contentDescription = null
            )
        }
    }

}


//@Preview
//@Composable
//fun ChapterBottomBarPreview() {
//    ChapterBottomBar()
//}