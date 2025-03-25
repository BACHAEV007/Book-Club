package com.example.booksapp.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.booksapp.data.detailsData
import com.example.booksapp.ui.component.BottomSheetContent
import com.example.booksapp.ui.component.ChapterBottomBar
import com.example.booksapp.ui.component.ChapterHeader
import com.example.booksapp.ui.component.HighlightedParagraph
import com.example.booksapp.ui.component.StagesCustomMenu
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreenContent(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    var isStageMenuVisible by remember { mutableStateOf(false) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var fontSize by remember { mutableStateOf(14f) }
    var lineSpacing by remember { mutableStateOf(1.5f) }
    var isPlay by remember { mutableStateOf(false) }
    var currentStageIndex by remember { mutableStateOf(detailsData.currentStageIndex) }

    val paragraphs = parseTextToParagraphs(detailsData.stages[currentStageIndex].text)

    val paragraphsWithRanges = mutableListOf<ParagraphWithRange>()
    var currentSentenceIndex = 0
    paragraphs.forEach { paragraph ->
        val sentenceCount = paragraph.sentences.size
        val sentenceRange = currentSentenceIndex until (currentSentenceIndex + sentenceCount)
        paragraphsWithRanges.add(ParagraphWithRange(paragraph, sentenceRange))
        currentSentenceIndex += sentenceCount
    }

    val lazyListState = rememberLazyListState()

    val totalSentences = paragraphsWithRanges.sumOf { it.paragraph.sentences.size }

    var currentHighlightedIndex by remember { mutableStateOf(-1) }
    val isFirstItemFullyVisible by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex == 0 && lazyListState.firstVisibleItemScrollOffset == 0
        }
    }
    val highlightedParagraphIndex by remember {
        derivedStateOf {
            if (currentHighlightedIndex == -1) {
                -1
            } else {
                paragraphsWithRanges.indexOfFirst { paragraphWithRange ->
                    currentHighlightedIndex in paragraphWithRange.sentenceRange
                }.takeIf { it != -1 } ?: 0
            }
        }
    }

    LaunchedEffect(highlightedParagraphIndex) {
        if (highlightedParagraphIndex != -1) {
            lazyListState.animateScrollToItem(
                index = highlightedParagraphIndex,
                scrollOffset = -75
            )
        }
    }

    LaunchedEffect(isPlay, detailsData.currentStageIndex) {

        if (isPlay) {
            val startIndex = if (currentHighlightedIndex == -1) 0 else currentHighlightedIndex
            for (i in startIndex until totalSentences) {
                if (i > startIndex) {
                    delay(3000L)
                }
                if (!isPlay) break
                currentHighlightedIndex = i
            }

            if (isPlay) {
                delay(3000L)
                currentHighlightedIndex = -1
            }
        }
    }

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ChapterHeader(modifier = Modifier, onBackClick, detailsData.stages[currentStageIndex].name, detailsData.title)
            Box(modifier = Modifier.weight(1f)){
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    state = lazyListState
                ) {

                    items(paragraphsWithRanges) { paragraphWithRange ->
                        HighlightedParagraph(
                            paragraph = paragraphWithRange.paragraph,
                            sentenceRange = paragraphWithRange.sentenceRange,
                            currentHighlightedIndex = currentHighlightedIndex,
                            lineSpacing = lineSpacing,
                            fontSize = fontSize
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.size(56.dp))
                    }

                }
                if (!isFirstItemFullyVisible){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .align(Alignment.TopCenter)
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        MaterialTheme.colorScheme.background,
                                        MaterialTheme.colorScheme.background.copy(alpha = 0f)
                                    )
                                )
                            )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .align(Alignment.BottomCenter)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                    MaterialTheme.colorScheme.background

                                )
                            )
                        )
                )

            }

            ChapterBottomBar(
                modifier = Modifier,
                onBackClick = { if (currentStageIndex > 0){
                    currentStageIndex--
                    detailsData.currentStageIndex--
                    isPlay = false
                    currentHighlightedIndex = -1
                } },
                onStagesClick = { isStageMenuVisible = !isStageMenuVisible },
                onForwardClick = { if (currentStageIndex < detailsData.stages.size - 1){
                    currentStageIndex++
                    detailsData.currentStageIndex++
                    isPlay = false
                    currentHighlightedIndex = -1
                } },
                onSettingsClick = { isBottomSheetVisible = !isBottomSheetVisible },
                onPlayClick = { isPlay = !isPlay },
                isPlay = isPlay
            )
        }
        AnimatedVisibility(
            visible = isStageMenuVisible,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth }
            ) + fadeIn(),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth }
            ) + fadeOut(),
        ) {
            StagesCustomMenu(
                modifier = Modifier,
                detailsData.stages,
                currentStageIndex,
                hideMenu = { isStageMenuVisible = !isStageMenuVisible }
            )
        }
        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = { isBottomSheetVisible = false },
                sheetState = bottomSheetState,
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                containerColor = MaterialTheme.colorScheme.background,
                scrimColor = Color.Transparent,
                dragHandle = {},
            ) {
                BottomSheetContent(
                    onCloseClick = { isBottomSheetVisible = false },
                    fontSize = fontSize,
                    onFontSizeChange = { fontSize = it },
                    lineSpacing = lineSpacing,
                    onLineSpacingChange = { lineSpacing = it },
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                            ambientColor = Color.Black.copy(alpha = 0.15f),
                            spotColor = Color.Black.copy(alpha = 0.30f),
                            clip = false
                        )
                )
            }
        }
    }

}

data class Paragraph(val sentences: List<String>)

data class ParagraphWithRange(
    val paragraph: Paragraph,
    val sentenceRange: IntRange
)

fun parseTextToParagraphs(text: String): List<Paragraph> {
    val paragraphs = text.split("\n").filter { it.isNotBlank() }
    return paragraphs.map { paragraphText ->
        val sentences = paragraphText.split(Regex("(?<=[.!?])\\s+|(?<=[.!?])$"))
            .filter { it.isNotBlank() }
            .map { it.trim() }
        Paragraph(sentences)
    }
}