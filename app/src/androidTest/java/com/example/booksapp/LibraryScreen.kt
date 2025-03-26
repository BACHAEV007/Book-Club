package com.example.booksapp

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.example.booksapp.data.Book
import com.example.booksapp.ui.LibraryTestTags
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class LibraryScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<LibraryScreen>(semanticsProvider = semanticsProvider) {

    val libraryTitle: KNode = child {
        hasTestTag(LibraryTestTags.LibraryTitleTestTag)
    }

    val newBooksTitle: KNode = child {
        hasTestTag(LibraryTestTags.NewBooksTitleTestTag)
    }

    val popularBooksTitle: KNode = child {
        hasTestTag(LibraryTestTags.PopularBooksTitleTestTag)
    }

    fun bookItem(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${LibraryTestTags.BookItemTestTagPrefix}$index")
    }

    fun bookImage(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${LibraryTestTags.BookImageTestTagPrefix}$index")
    }

    fun bookTitle(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${LibraryTestTags.BookTitleTestTagPrefix}$index")
    }

    fun bookAuthor(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${LibraryTestTags.BookAuthorTestTagPrefix}$index")
    }

    fun checkCommonUi() {
        libraryTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("БИБЛИОТЕКА")
        }

        newBooksTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("НОВИНКИ")
        }

        popularBooksTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("ПОПУЛЯРНЫЕ КНИГИ")
        }

    }


    fun checkBooksDisplayed(bookList: List<Book>) {
        bookList.forEachIndexed { index, book ->
            bookItem(index) {
                assertIsDisplayed()
            }

            bookImage(index) {
                assertIsDisplayed()
            }

            bookTitle(index) {
                assertIsDisplayed()
                assertTextEquals(book.title.uppercase())
            }

            bookAuthor(index) {
                assertIsDisplayed()
                assertTextEquals(book.author)
            }
        }
    }

    fun checkBookClick(index: Int, onClick: () -> Unit) {
        bookItem(index) {
            performClick()
            onClick()
        }
    }

    fun checkNoBooks() {
        bookItem(0) {
            assertDoesNotExist()
        }
    }
}