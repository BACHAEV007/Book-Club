package com.example.booksapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.booksapp.ui.BookmarksTestTags
import com.example.booksapp.ui.MainTestTag
import com.example.booksapp.ui.SignInTestTags
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenNavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var signInScreen: SignInScreen
    private lateinit var bookDetailScreen: BookDetailsScreen

    @Before
    fun setup() {
        signInScreen = SignInScreen(composeTestRule)
        bookDetailScreen = BookDetailsScreen(composeTestRule)
    }

    private fun launchMainScreen() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            MainScreen(navController = navController, isTesting = true)
        }
        composeTestRule.waitForIdle()
        Thread.sleep(1000)
    }

    @Test
    fun testNavigationThroughAllScreens() = runTest {
        launchMainScreen()
        composeTestRule.onNodeWithTag(MainTestTag.SignInScreenContent).assertIsDisplayed()
        signInScreen.checkCommonUi()
        signInScreen.checkFillTextFieldAndEnableButton()
        composeTestRule.onNodeWithTag(SignInTestTags.SignInButtonTestTag).performClick()
        composeTestRule.onNodeWithTag(MainTestTag.LibraryScreenContent).assertIsDisplayed()
        composeTestRule.onNodeWithTag(MainTestTag.BottomBarItem + "${1}").performClick()
        composeTestRule.onNodeWithTag(MainTestTag.SearchScreenContent).assertIsDisplayed()
        composeTestRule.onNodeWithTag(MainTestTag.BottomBarItem + "${3}").performClick()
        composeTestRule.onNodeWithTag(MainTestTag.BookmarksScreenContent).assertIsDisplayed()
        composeTestRule.onNodeWithTag(BookmarksTestTags.SearchBookItemTestTagPrefix + 0)
            .performClick()
        composeTestRule.onNodeWithTag(MainTestTag.BookDetailScreenContent).assertIsDisplayed()
        bookDetailScreen.onReadButtonClick()
        composeTestRule.onNodeWithTag(MainTestTag.ChapterScreenContent).assertIsDisplayed()
    }
}