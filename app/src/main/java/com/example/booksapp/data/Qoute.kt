package com.example.booksapp.data

data class Quote(val quote: String, val description: String)

val quoteList = listOf(
    Quote(
        quote = "Я все еще жив",
        description = "Код да Винчи • Дэн Браун",
    ),
    Quote(
        quote = "Высокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
                "белыми волосами",
        description = "Код да Винчи • Дэн Браун",
    ),
    Quote(
        quote = "Я ТАК ЛЮБЛЮ МОБИЛКУ",
        description = "Архитектура Бачаева • Бачаев Марат",
    )
)