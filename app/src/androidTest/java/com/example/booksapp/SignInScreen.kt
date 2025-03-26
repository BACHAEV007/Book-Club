package com.example.booksapp

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.isEnabled
import com.example.booksapp.ui.SignInTestTags
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class SignInScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<SignInScreen>(semanticsProvider = semanticsProvider) {
    val button: KNode = child {
        hasTestTag(SignInTestTags.SignInButtonTestTag)
    }

    val greetingText: KNode = child {
        hasTestTag(SignInTestTags.SignInTextTestTag)
    }

    val emailText: KNode = child {
        hasTestTag(SignInTestTags.SignInEmailTestTag)
    }

    val passwordText: KNode = child {
        hasTestTag(SignInTestTags.SignInPasswordTestTag)
    }

    fun checkCommonUi() {
        button {
            waitUntil { assertIsDisplayed() }
            performClick()
        }

        emailText {
            assertIsDisplayed()
        }

        passwordText {
            assertIsDisplayed()
        }

        greetingText {
            waitUntil { assertTextEquals("ОТКРОЙ ДЛЯ СЕБЯ") }
        }
    }

    fun checkFillTextFieldAndEnableButton() {
        emailText {
            performTextInput("test@example.com")
            assertTextEquals("test@example.com")
        }

        passwordText {
            performTextInput("MyPassword123")
        }

        button {
            isEnabled()
        }
    }

}