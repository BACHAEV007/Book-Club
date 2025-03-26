package com.example.booksapp.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booksapp.ui.Paragraph
import com.example.booksapp.ui.theme.Georgia

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
            val isItalic = sentence.startsWith("*")
            val displaySentence = if (isItalic) sentence.removePrefix("*").trim() else sentence
            val colorStyle = if (globalIndex == currentHighlightedIndex) {
                SpanStyle(color = MaterialTheme.colorScheme.onSecondary)
            } else {
                SpanStyle(color = MaterialTheme.colorScheme.onBackground)
            }

            val combinedStyle = if (isItalic) {
                colorStyle.copy(fontStyle = FontStyle.Italic)
            } else {
                colorStyle.copy(fontStyle = FontStyle.Normal)
            }

            withStyle(style = combinedStyle) {
                append(displaySentence)
                if (index < paragraph.sentences.size - 1) {
                    append(". ")
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