package com.example.booksapp.data

data class Stage(
    val name: String,
    val isRead: Boolean
)

data class BookDetailData(
    val title: String,
    val author: String,
    val description: String,
    val isBookFullyRead: Boolean,
    val image: String,
    val percent: Float,
    val stages: List<Stage>,
    val currentStageIndex: Int
)



val detailsData: BookDetailData = BookDetailData(
    title = "Код для войны",
    description = "Секретный код скрыт в плотах древних святиков...\nЧтобы он помог обрести хрупкий мир, нужно собрать древние святики, дающие немыслимые знания и могущество...\nКлюч к немыслимым тайнам, над которым бились лучшие умы, иконки может быть только...",
    author = "Дэн Браун",
    isBookFullyRead = false,
    percent = 16f,
    image = "https://s3-alpha-sig.figma.com/img/e11b/cb67/f5e3dc5e3a35431158e3ccca0bd40b5b?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NQfOYlq34HRq32ftA7l1I-Tdd~htEktlLHbe65jxe8LH52aGpj3TPA~SjnzRa22jXBOLlZntcTruX40udq9xp04GPgLZGgsr6YQ6fOO-YWAzfWaacmsHPt-Vjw~2bfw-2YighWpBsfvc5oHNxib4I947zBcLEQxRveribhFw-ZvU06FZ2jf7msdDTnpcDzAkwyJvcJ-aFPcRCDTR~thlfUOVyc69Iu4WHHKP0cHag87ASZv1SrG2cXjjoB9N7cjudcH5iql39HedvRw8cD9j-KEowWTXkvaUnfR6vT4RRF5kcMXVef202Z-IjFM8zypU9WtI1cb9OABFvt2VMwTMJw__",
    stages = listOf(
        Stage(name = "Факты", isRead = true),
        Stage(name = "Пролог", isRead = true),
        Stage(name = "Глава 1", isRead = false),
        Stage(name = "Глава 2", isRead = false),
        Stage(name = "Глава 3", isRead = false),
        Stage(name = "Глава 4", isRead = false),
        Stage(name = "Глава 5", isRead = false),
        Stage(name = "Глава 6", isRead = false),
        Stage(name = "Глава 7", isRead = false),
        Stage(name = "Глава 8", isRead = false),
        Stage(name = "Глава 9", isRead = false),
        Stage(name = "Глава 10", isRead = false),
        Stage(name = "Глава 11", isRead = false),
        Stage(name = "Глава 12", isRead = false),
        Stage(name = "Глава 13", isRead = false)
    ),
    currentStageIndex = 2
)