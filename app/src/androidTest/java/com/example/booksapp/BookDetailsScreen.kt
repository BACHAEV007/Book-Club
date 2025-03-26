package com.example.booksapp

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.example.booksapp.data.BookDetailData
import com.example.booksapp.data.Stage
import com.example.booksapp.ui.BookDetailsTestTags
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class BookDetailsScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<BookDetailsScreen>(semanticsProvider = semanticsProvider) {

    val bookDetailHeader: KNode = child {
        hasTestTag(BookDetailsTestTags.BookDetailHeaderTestTag)
    }

    val tablesTitle: KNode = child {
        hasTestTag(BookDetailsTestTags.TablesTitleTestTag)
    }

    val bookDetailsDescription: KNode = child {
        hasTestTag(BookDetailsTestTags.BookDetailsDescriptionTestTag)
    }

    val bookDetailProlonged: KNode = child {
        hasTestTag(BookDetailsTestTags.BookDetailProlongedTestTag)
    }

    val haveReadTitle: KNode = child {
        hasTestTag(BookDetailsTestTags.HaveReadTitleTestTag)
    }

    val progressBar: KNode = child {
        hasTestTag(BookDetailsTestTags.ProgressBarTestTag)
    }

    fun stageItem(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookDetailsTestTags.StageItemTestTagPrefix}$index")
    }

    fun checkCommonUi() {
        bookDetailHeader {
            waitUntil { assertIsDisplayed() }
        }

        bookDetailsDescription {
            waitUntil { assertIsDisplayed() }
        }

        tablesTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("ОГЛАВЛЕНИЕ")
        }
    }


    fun checkBookDetailProlonged(percent: Float) {
        bookDetailProlonged {
            assertIsDisplayed()
        }

        haveReadTitle {
            assertIsDisplayed()
            assertTextEquals("ПРОЧИТАНО")
        }

        progressBar {
            assertIsDisplayed()
        }
    }


    fun checkNoBookDetailProlonged() {
        bookDetailProlonged {
            assertDoesNotExist()
        }
    }

    fun checkStages(stages: List<Stage>, currentStageIndex: Int) {
        stages.forEachIndexed { index, stage ->
            stageItem(index) {
                assertIsDisplayed()
                assertTextEquals(stage.name)
            }
        }

        stageItem(stages.size) {
            assertDoesNotExist()
        }
    }

    fun checkStageClick(index: Int, onClick: (Int) -> Unit) {
        stageItem(index) {
            performClick()
            onClick(index)
        }
    }


    fun checkNoStages() {
        stageItem(0) {
            assertDoesNotExist()
        }
    }
}