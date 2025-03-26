import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.booksapp.BookDetailsScreen
import com.example.booksapp.data.BookDetailData
import com.example.booksapp.data.Stage
import com.example.booksapp.ui.BookDetailsContent
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookDetailsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var bookDetailsScreen: BookDetailsScreen

    private val testBookDetailData = BookDetailData(
        image = "https://s3-alpha-sig.figma.com/img/e11b/cb67/f5e3dc5e3a35431158e3ccca0bd40b5b?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=QoPI95Je-CpIVblhHJJlQ8ndGSQEeTaXe--Jcwdx5ivbexaPkKe28miQz8YYwDIqDWMv-9eUfm4B5WAoLowNpLbWpRZDiIvInEosF1zTuVdotqCW~jd~UdQCrVm14q2zKIYrjNTjLqndJ~ECEctyOgO5jr8w8CdLb9jSKsYEXO7zGQ-wDEwqDEWkiof9KwwaZ9ILv~sKwfeKOlGEowKt991S0P3jcan-89RzfaSLt1jvjhznFdQwxuz5K31~Iaa2XPUv5We3Ywgjun7Q1mSLi2vdmKmO1DJFr5Yxl7lhek9RyoEgIIl6vKz2dMymk0~kJGdoFmcoM1yQdLYDPbgRjw__",
        title = "Код да винчи",
        author = "Дэн Браун",
        description = "Текст 1\nТекст 2\nТекст 3",
        percent = 50f,
        stages = listOf(
            Stage(name = "Глава 1", text = "", isRead = true),
            Stage(name = "Глава 2", text = "", isRead = false),
            Stage(name = "Глава 3", text = "", isRead = false)
        ),
        currentStageIndex = 1,
        isBookFullyRead = false
    )

    private val testBookDetailDataNoProgress = BookDetailData(
        image = "",
        title = "",
        author = "",
        description = "",
        percent = 0f,
        stages = emptyList(),
        currentStageIndex = 0,
        isBookFullyRead = false
    )

    @Before
    fun setup() {
        bookDetailsScreen = BookDetailsScreen(composeTestRule)
    }

    private fun launchBookDetailsScreen(
        bookDetailData: BookDetailData = testBookDetailData,
        onBackClick: () -> Unit = {},
        onStageClick: (Int) -> Unit = {}
    ) {
        composeTestRule.setContent {
            BookDetailsContent(
                onBackClick = onBackClick,
                onStageClick = onStageClick,
                topBarPadding = 0.dp,
                detailsData = bookDetailData
            )
        }
        composeTestRule.waitForIdle()
    }

    @Test
    fun testBookDetailsScreenWithProgress() = runTest {
        var stageClickedIndex: Int? = null
        launchBookDetailsScreen(
            bookDetailData = testBookDetailData,
            onStageClick = { index -> stageClickedIndex = index }
        )

        bookDetailsScreen.checkCommonUi()


        bookDetailsScreen.checkBookDetailProlonged(testBookDetailData.percent)

        bookDetailsScreen.checkStages(
            testBookDetailData.stages,
            testBookDetailData.currentStageIndex
        )

        bookDetailsScreen.checkStageClick(1) { index ->
            assertEquals("Клик на 1 stage", 1, index)
            assertEquals("indexStage = 1", 1, stageClickedIndex)
        }

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }

    @Test
    fun testBookDetailsScreenWithoutData() = runTest {
        launchBookDetailsScreen(
            bookDetailData = testBookDetailDataNoProgress
        )

        bookDetailsScreen.checkCommonUi()


        bookDetailsScreen.checkNoBookDetailProlonged()

        bookDetailsScreen.checkNoStages()

        composeTestRule
            .onRoot()
            .printToLog("semantic tree")
    }
}