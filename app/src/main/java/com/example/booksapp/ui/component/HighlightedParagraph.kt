package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booksapp.ui.Paragraph
import com.example.booksapp.ui.theme.Georgia
import kotlinx.coroutines.delay

@Composable
fun HighlightedParagraph(
    paragraph: Paragraph,
    sentenceRange: IntRange,
    currentHighlightedIndex: Int,
    fontSize: Float,
    lineSpacing: Float
) {
    val annotatedString = buildAnnotatedString {
        paragraph.sentences.forEachIndexed { index, sentence ->
            val globalIndex = sentenceRange.first + index
            if (globalIndex == currentHighlightedIndex) {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondary)) {
                    append(sentence)
                    if (index < paragraph.sentences.size - 1) {
                        append(". ")
                    }
                }
            } else {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append(sentence)
                    if (index < paragraph.sentences.size - 1) {
                        append(". ")
                    }
                }
            }
        }
    }

    Text(
        text = annotatedString,
        style = TextStyle(
            fontSize = fontSize.sp,
            lineHeight = (fontSize * lineSpacing).sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = Georgia,
            fontWeight = FontWeight.Medium,
        ),
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    )
}