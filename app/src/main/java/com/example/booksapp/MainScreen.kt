package com.example.booksapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booksapp.screen.SignInScreen
import com.example.booksapp.ui.SignInScreenContent


@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SignInScreen
    ){
        composable<SignInScreen> {
            SignInScreenContent(modifier = modifier.fillMaxSize())
        }
    }
}