package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booksapp.R
import kotlinx.serialization.Serializable

@Composable
fun CustomBottomBar(
    currentRoute: String,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val routeToIndex = mapOf(
        "com.example.booksapp.screen.LibraryScreen" to 0,
        "com.example.booksapp.screen.SearchScreen" to 1,
        "com.example.booksapp.screen.BookmarksScreen" to 3
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
                    modifier = Modifier.size(48.dp)
                        .clip(CircleShape)

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

//@Preview
//@Composable
//fun CustomBottomBarPreview() {
//    CustomBottomBar(selectedIndex = 0, onItemSelected = {})
//}