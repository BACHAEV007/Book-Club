package com.example.booksapp

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.booksapp.ui.SignInScreenContent
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import org.junit.Rule
import org.junit.Test

class SignInScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCommonUi() {
        composeTestRule.launchSignInScreen()
        onComposeScreen<SignInScreen>(composeTestRule) {
            checkCommonUi()
        }

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }

    @Test
    fun testFillInputField() {
        composeTestRule.launchSignInScreen()
        onComposeScreen<SignInScreen>(composeTestRule) {
            checkFillTextFieldAndEnableButton()
        }

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }

    private fun ComposeContentTestRule.launchSignInScreen() {
        setContent {
            SignInScreenContent(
                onEnterClick = { },
                isTesting = true
            )
        }
    }
}