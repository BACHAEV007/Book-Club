package com.example.booksapp.utils

import com.example.booksapp.data.Paragraph

fun parseTextToParagraphs(text: String): List<Paragraph> {
    val paragraphs = text.split("\n").filter { it.isNotBlank() }
    return paragraphs.map { paragraphText ->
        val sentences = paragraphText.split(Regex("(?<=[.!?])\\s+|(?<=[.!?])$"))
            .filter { it.isNotBlank() }
            .map { it.trim() }
        Paragraph(sentences)
    }
}