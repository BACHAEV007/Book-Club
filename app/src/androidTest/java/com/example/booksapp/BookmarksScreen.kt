import io.github.kakaocup.compose.node.element.KNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import com.example.booksapp.data.Book
import com.example.booksapp.data.Quote
import com.example.booksapp.ui.BookmarksTestTags
import io.github.kakaocup.compose.node.element.ComposeScreen

class BookmarksScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<BookmarksScreen>(semanticsProvider = semanticsProvider) {

    val bookmarksTitle: KNode = child {
        hasTestTag(BookmarksTestTags.BookmarksTitleTestTag)
    }

    val readingNowTitle: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowTitleTestTag)
    }

    val favoritesBooksTitle: KNode = child {
        hasTestTag(BookmarksTestTags.FavoritesBooksTitleTestTag)
    }

    val quotesTitle: KNode = child {
        hasTestTag(BookmarksTestTags.QuotesTitleTestTag)
    }

    val readingNowRow: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowRowTestTag)
    }

    val playButton: KNode = child {
        hasTestTag(BookmarksTestTags.PlayButtonTestTag)
    }

    val readingNowBookItem: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowBookItemTestTag)
    }

    val readingNowBookImage: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowBookImageTestTag)
    }

    val readingNowBookTitle: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowBookTitleTestTag)
    }

    val readingNowBookStage: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowBookStageTestTag)
    }

    val readingNowProgressBar: KNode = child {
        hasTestTag(BookmarksTestTags.ReadingNowProgressBarTestTag)
    }

    fun searchBookItem(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.SearchBookItemTestTagPrefix}$index")
    }

    fun searchBookImage(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.SearchBookImageTestTagPrefix}$index")
    }

    fun searchBookTitle(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.SearchBookTitleTestTagPrefix}$index")
    }

    fun searchBookAuthor(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.SearchBookAuthorTestTagPrefix}$index")
    }

    fun quoteItem(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.QuoteItemTestTagPrefix}$index")
    }

    fun quoteText(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.QuoteTextTestTagPrefix}$index")
    }

    fun quoteDescription(index: Int, function: () -> Unit): KNode = child {
        hasTestTag("${BookmarksTestTags.QuoteDescriptionTestTagPrefix}$index")
    }

    fun checkCommonUi() {
        bookmarksTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("ЗАКЛАДКИ")
        }

        readingNowTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("ЧИТАЕТЕ СЕЙЧАС")
        }

        favoritesBooksTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("ИЗБРАННЫЕ КНИГИ")
        }

        quotesTitle {
            waitUntil { assertIsDisplayed() }
            assertTextEquals("ЦИТАТЫ")
        }

        readingNowRow {
            waitUntil { assertIsDisplayed() }
        }

        playButton {
            waitUntil { assertIsDisplayed() }
        }
    }

    fun checkReadingNowBook(book: Book, percent: Float, stage: String) {
        readingNowBookItem {
            assertIsDisplayed()
        }

        readingNowBookImage {
            assertIsDisplayed()
        }

        readingNowBookTitle {
            assertIsDisplayed()
            assertTextEquals(book.title.uppercase())
        }

        readingNowBookStage {
            assertIsDisplayed()
            assertTextEquals(stage)
        }

        if (percent != 0f) {
            readingNowProgressBar {
                assertIsDisplayed()
            }
        } else {
            readingNowProgressBar {
                assertDoesNotExist()
            }
        }
    }

    fun checkFavoritesBooks(bookList: List<Book>) {
        bookList.forEachIndexed { index, book ->
            searchBookItem(index) {
                assertIsDisplayed()
            }

            searchBookImage(index) {
                assertIsDisplayed()
            }

            searchBookTitle(index) {
                assertIsDisplayed()
                assertTextEquals(book.title.uppercase())
            }

            searchBookAuthor(index) {
                assertIsDisplayed()
                assertTextEquals(book.author)
            }
        }

        searchBookItem(bookList.size) {
            assertDoesNotExist()
        }
    }

    fun checkQuotes(quoteList: List<Quote>) {
        quoteList.forEachIndexed { index, quote ->
            quoteItem(index) {
                assertIsDisplayed()
            }

            quoteText(index) {
                assertIsDisplayed()
                assertTextEquals(quote.quote)
            }

            quoteDescription(index) {
                assertIsDisplayed()
                assertTextEquals(quote.description)
            }
        }

        quoteItem(quoteList.size) {
            assertDoesNotExist()
        }
    }

    fun checkBookClick(index: Int, onClick: () -> Unit) {
        searchBookItem(index) {
            performClick()
            onClick()
        }
    }

    fun checkPlayButtonClick(onClick: () -> Unit) {
        playButton {
            performClick()
            onClick()
        }
    }

    fun checkNoReadingNowBook() {
        readingNowBookItem {
            assertDoesNotExist()
        }
    }

    fun checkNoFavoritesBooks() {
        searchBookItem(0) {
            assertDoesNotExist()
        }
    }

    fun checkNoQuotes() {
        quoteItem(0) {
            assertDoesNotExist()
        }
    }
}