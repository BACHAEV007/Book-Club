import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.booksapp.data.Book
import com.example.booksapp.data.Quote
import com.example.booksapp.ui.BookmarksScreenContent
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookmarksScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var bookmarksScreen: BookmarksScreen

    private val testBookList = listOf(
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Автор 1",
            description = "Описание 1",
            title = "НАЗВАНИЕ 1"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Автор 2",
            description = "Описание 2",
            title = "НАЗВАНИЕ 2"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Автор 3",
            description = "Описание 3",
            title = "НАЗВАНИЕ 3"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Автор 4",
            description = "Описание 4",
            title = "НАЗВАНИЕ 4"
        ),
        Book(
            imageUrl = "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=ZMDFB~-iDEZalcAKtwYTp4Sc0W0BYmQMDGpmHwf46WRGYU8sTdKrPZY5LSe0GEXvL8kZYn-N~TWK7XOCp7tpt6VlAU9u6CQCEnjl31W6MBjy9yzLwWbWzjP28h3l7r2pv53iOhgYeWkNDXDTNtCVHUCxYt8t5smUD0VA5n2Ls9MC6jqlXomQe-RCkRip8gBF6zwHAezF4YlDrrqNPmVl8AD5prKrS0YKUyNTdqEXpRAdapVMVY3ZpZ7JslzevDLfgSicsJE5xnao3oZMJsRsrTjwXH8Escp4uFjhUqcZN~ZkctuafMIDqa-TewhCARa5qMy85GqljMsuea2DvRXrHw__",
            author = "Автор 5",
            description = "Описание 5",
            title = "НАЗВАНИЕ 5"
        )
    )

    private val testQuoteList = listOf(
        Quote(
            quote = "Цитата 1",
            description = "Описание 1"
        ),
        Quote(
            quote = "Цитата 2",
            description = "Описание 2"
        )
    )

    private val testPercent = 50f
    private val testStage = "Глава 1"

    @Before
    fun setup() {
        bookmarksScreen = BookmarksScreen(composeTestRule)
    }

    private fun launchBookmarksScreen(
        bookList: List<Book> = testBookList,
        quoteList: List<Quote> = testQuoteList,
        onBookClick: () -> Unit = {},
        onReadNowClick: () -> Unit = {}
    ) {
        composeTestRule.setContent {
            BookmarksScreenContent(
                onBookClick = onBookClick,
                onReadNowClick = onReadNowClick,
                bookList = bookList,
                quoteList = quoteList
            )
        }
        composeTestRule.waitForIdle()
    }

    @Test
    fun testBookmarksScreenWithData() = runTest {
        var bookClicked = false
        var playClicked = false
        launchBookmarksScreen(
            bookList = testBookList,
            quoteList = testQuoteList,
            onBookClick = { bookClicked = true },
            onReadNowClick = { playClicked = true }
        )

        bookmarksScreen.checkCommonUi()

        bookmarksScreen.checkReadingNowBook(
            book = testBookList[0],
            percent = testPercent,
            stage = testStage
        )

        bookmarksScreen.checkFavoritesBooks(testBookList.subList(2, 5))

        bookmarksScreen.checkQuotes(testQuoteList)


        bookmarksScreen.checkBookClick(0) {
            assertTrue("onBookClick", bookClicked)
        }

        bookmarksScreen.checkPlayButtonClick {
            assertTrue("onReadNowClick", playClicked)
        }

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }

    @Test
    fun testBookmarksScreenWithoutData() = runTest {
        launchBookmarksScreen(
            bookList = emptyList(),
            quoteList = emptyList()
        )

        bookmarksScreen.checkCommonUi()

        bookmarksScreen.checkNoReadingNowBook()

        bookmarksScreen.checkNoFavoritesBooks()

        bookmarksScreen.checkNoQuotes()

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }
}