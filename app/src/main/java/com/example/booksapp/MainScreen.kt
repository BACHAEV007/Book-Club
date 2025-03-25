package com.example.booksapp

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.collection.mutableObjectIntMapOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.booksapp.screen.BookDetailScreen
import com.example.booksapp.screen.BookmarksScreen
import com.example.booksapp.screen.ChapterScreen
import com.example.booksapp.screen.LibraryScreen
import com.example.booksapp.screen.SearchScreen
import com.example.booksapp.screen.SignInScreen
import com.example.booksapp.ui.BookDetailsContent
import com.example.booksapp.ui.BookmarksScreenContent
import com.example.booksapp.ui.ChapterScreenContent
import com.example.booksapp.ui.LibraryScreenContent
import com.example.booksapp.ui.SearchScreenContent
import com.example.booksapp.ui.SignInScreenContent
import com.example.booksapp.ui.component.CustomBottomBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ContextCastToActivity")
@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val window = LocalContext.current as? Activity
    LaunchedEffect(currentRoute) {
        window?.let { activity ->
            WindowCompat.getInsetsController(activity.window, activity.window.decorView)
                .let { controller ->
                    controller.isAppearanceLightStatusBars = when (currentRoute) {
                        "com.example.booksapp.screen.BookDetailScreen" -> false
                        else -> true
                    }
                }
        }
    }
    Scaffold(
        floatingActionButton = {
            if (currentRoute in listOf(
                    "com.example.booksapp.screen.LibraryScreen",
                    "com.example.booksapp.screen.SearchScreen",
                    "com.example.booksapp.screen.BookmarksScreen"
                )
            ) {
                Box(
                    modifier = Modifier
                        .offset(y = 24.dp)
                        .padding(horizontal = 16.dp)

                ) {
                    FloatingActionButton(
                        onClick = { navController.navigate(BookDetailScreen) },
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.BottomCenter)
                            .offset(y = 64.dp)
                            .clip(RoundedCornerShape(64.dp)),
                        containerColor = Color.Red
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.play_ic),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.surface,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (currentRoute in listOf(
                    "com.example.booksapp.screen.LibraryScreen",
                    "com.example.booksapp.screen.SearchScreen",
                    "com.example.booksapp.screen.BookmarksScreen",
                )
            ) {
                Box(
                    modifier = Modifier

                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                        .windowInsetsPadding(WindowInsets.navigationBars)
                ) {
                    when (currentRoute) {
                        "com.example.booksapp.screen.LibraryScreen",
                        "com.example.booksapp.screen.SearchScreen",
                        "com.example.booksapp.screen.BookmarksScreen"
                            -> {
                            CustomBottomBar(
                                currentRoute = currentRoute,
                                onItemSelected = { newIndex ->
                                    selectedIndex = newIndex
                                    when (newIndex) {
                                        0 -> navController.navigate(LibraryScreen) {
                                            popUpTo(LibraryScreen) {
                                                inclusive = true
                                            }
                                        }

                                        1 -> navController.navigate(SearchScreen) {
                                            popUpTo(LibraryScreen) {
                                                inclusive = false
                                            }
                                        }

                                        3 -> navController.navigate(BookmarksScreen) {
                                            popUpTo(LibraryScreen) {
                                                inclusive = false
                                            }
                                        }
                                        4 -> navController.navigate(SignInScreen){
                                            popUpTo(LibraryScreen) {
                                                inclusive = true
                                            }
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = SignInScreen,
                modifier = Modifier
            ) {
                composable<SignInScreen> {
                    SignInScreenContent(modifier = modifier.fillMaxSize(), {
                        navController.navigate(
                            LibraryScreen
                        ) {
                            popUpTo(SignInScreen) {
                                inclusive = true
                            }

                        }
                    })
                }
                composable<LibraryScreen> {
                    LibraryScreenContent(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    )
                }
                composable<SearchScreen> {
                    SearchScreenContent(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    )
                }
                composable<BookmarksScreen> {
                    BookmarksScreenContent(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    )
                }
                composable<BookDetailScreen> {
                    val statusBarHeight =
                        WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
                    BookDetailsContent(
                        modifier = modifier
                            .fillMaxSize()
                            .offset(y = -statusBarHeight),
                        onBackClick = { navController.popBackStack() },
                        onStageClick = { navController.navigate(ChapterScreen) },
                        topBarPadding = statusBarHeight
                    )
                }
                composable<ChapterScreen> {
                    ChapterScreenContent(
                        modifier = modifier
                            .fillMaxSize(),
                        onBackClick = { navController.popBackStack() },
                    )
                }
            }
        }
    }
}