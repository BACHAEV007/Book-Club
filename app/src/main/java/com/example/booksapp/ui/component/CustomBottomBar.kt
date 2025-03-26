package com.example.booksapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.constants.Routes
import com.example.booksapp.ui.MainTestTag

@Composable
fun CustomBottomBar(
    currentRoute: String,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val routeToIndex = mapOf(
        Routes.LIBRARY_SCREEN to 0,
        Routes.SEARCH_SCREEN to 1,
        Routes.BOOKMARKS_SCREEN to 3
    )


    val selectedIndex = routeToIndex[currentRoute] ?: 0
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(100)),
        containerColor = MaterialTheme.colorScheme.primary,
        contentPadding = PaddingValues(0.dp),
        tonalElevation = 0.dp,
        windowInsets = WindowInsets(0.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val icons = listOf(
                R.drawable.library_bottom_ic,
                R.drawable.search_bottom_ic,
                R.drawable.play_ic,
                R.drawable.favorites_bottom_ic,
                R.drawable.logout_bottom_ic
            )

            icons.forEachIndexed { index, iconRes ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .testTag(buildString {
                            append(MainTestTag.BottomBarItem)
                            append("${index}")
                        })

                        .clickable { onItemSelected(index) },
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = null,
                        tint = if (index == selectedIndex) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

