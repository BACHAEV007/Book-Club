package com.example.booksapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.booksapp.data.Book
import com.example.booksapp.ui.LibraryScreenContent
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LibraryScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var libraryScreen: LibraryScreen

    private val testBookList = listOf(
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Tестовый Автор 1",
            description = "Тестовое Описание 1",
            title = "Тестовое Название 1"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Tестовый Автор 2",
            description = "Тестовое Описание 2",
            title = "Тестовое Название 2"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Tестовый Автор 3",
            description = "Тестовое Описание 3",
            title = "Тестовое Название 3"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Tестовый Автор 4",
            description = "Тестовое Описание 4",
            title = "Тестовое Название 4"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Tестовый Автор 5",
            description = "Тестовое Описание 5",
            title = "Тестовое Название 5"
        )
    )

    @Before
    fun setup() {
        libraryScreen = LibraryScreen(composeTestRule)
    }

    @Test
    fun testLibraryScreenWithBooks() = runTest {
        var clicked = false
        launchLibraryScreen(testBookList)

        libraryScreen.checkCommonUi()

        libraryScreen.checkBooksDisplayed(testBookList)

        libraryScreen.checkBookClick(0) {
            assertTrue("onBookClick", clicked)
        }
        libraryScreen.checkBookClick(4) {
            assertTrue("onBookClick", clicked)
        }

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }

    @Test
    fun testLibraryScreenWithoutBooks() = runTest {
        launchLibraryScreen(emptyList())

        libraryScreen.checkCommonUi()

        libraryScreen.checkNoBooks()

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }

    private fun launchLibraryScreen(bookList: List<Book> = testBookList) {
        composeTestRule.setContent {
            LibraryScreenContent(
                onBookClick = { },
                bookList = bookList
            )
        }
    }
}