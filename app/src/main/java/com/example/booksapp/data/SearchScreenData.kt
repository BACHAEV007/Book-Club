package com.example.booksapp.data

data class SearchScreenData(
    val searchPlaceholder: String = "Поиск по книгам",
    val filter: List<String> = listOf("iOS"),
    val genres: List<String> = listOf(
        "Классика",
        "Фантастика",
        "Триллер",
        "Любовный роман",
        "Поэзия",
        "Для подростков",
        "Фэнтези",
        "Детектив",
        "Исторический роман",
        "Приключения",
        "Биография",
        "Детективы"
    ),
    val authors: List<Author> = listOf(
        Author(
            imageUrl = "https://s3-alpha-sig.figma.com/img/554e/d976/58713175fa8334c8e0318b7bcf1ca253?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=b-4xPMvdHJShbWFnhcYK81neWuGhvn59AMVP0N7lJZS7mszE-gy4fIV~6HRy677ND6OcE3HOdIErlazGcrcQ4eHqWJrlOWkpfZMJQtBoxzQAmbJdrkHwSZHl5ef3~84W1GoFSIOHyRIPahFdw6Gx7N4iFqdQOPRAc4fR65hrUTfCemn3WPRwUmIdeDMUwz6x7yRLi22LHcExEbXKeAygVp4sbrF-V2fYjKU2JnmJMa9HZ6B9wx4ReuvigTKRCLnOJsxYMVeYxvY20UzYe~Laj8ZTXnxQjIJ0Bi0uxUqc3aKyXX2l2QPXmARHkgH97Ri-MGLF1~-Lg7XdrtftZ70rPQ__",
            name = "Братья Стругацкие"
        ),
        Author(
            imageUrl = "https://s3-alpha-sig.figma.com/img/554e/d976/58713175fa8334c8e0318b7bcf1ca253?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=b-4xPMvdHJShbWFnhcYK81neWuGhvn59AMVP0N7lJZS7mszE-gy4fIV~6HRy677ND6OcE3HOdIErlazGcrcQ4eHqWJrlOWkpfZMJQtBoxzQAmbJdrkHwSZHl5ef3~84W1GoFSIOHyRIPahFdw6Gx7N4iFqdQOPRAc4fR65hrUTfCemn3WPRwUmIdeDMUwz6x7yRLi22LHcExEbXKeAygVp4sbrF-V2fYjKU2JnmJMa9HZ6B9wx4ReuvigTKRCLnOJsxYMVeYxvY20UzYe~Laj8ZTXnxQjIJ0Bi0uxUqc3aKyXX2l2QPXmARHkgH97Ri-MGLF1~-Lg7XdrtftZ70rPQ__",
            name = "Дэн Браун"
        )
    ),
)

data class Author(
    val imageUrl: String,
    val name: String
)

val searchScreenData: SearchScreenData =
    SearchScreenData(
        searchPlaceholder = "Поиск по книгам",
        filter = listOf("iOS"),
        genres = listOf(
            "Классика",
            "Фантастика",
            "Триллер",
            "Любовный роман",
            "Поэзия",
            "Для подростков",
            "Фэнтези",
            "Детектив",
            "Исторический роман",
            "Приключения",
            "Биография",
            "Детективы"
        ),
        authors = listOf(
            Author(
                imageUrl = "https://s3-alpha-sig.figma.com/img/554e/d976/58713175fa8334c8e0318b7bcf1ca253?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=QVTkGNTR3fFrRuW5uRGAU-rYrZRVJ6eVCmeTedxLPNxvc1yiK~jqXEIzpGuGEQnlQlhFYARjWSGqA0Uz7PqT4uB2uCddr9LZmPQaR-yMGChjp1C26eqRTYgCVFhcy4gLvmhqUV8eUVRowdZF8d6ue4yBJ9yZy6L23qCKMIwac3074x8CRceiE0-rYdrP5JI5DfqC0VQPKs1-VFYp0cYBFPhntYEY~ahpyI8Vj2SIhPGEYMyNVFmreDzqZegmBlA8nSlrVEXpOWmSy5lkkKqU~Y89XM~1WN-xJp144uCSyqN0Xo70gd8SRxM-wo4sRwN8CSBa6HDJrzQcyDuyuqa45g__",
                name = "Братья Стругацкие"
            ),
            Author(
                imageUrl = "https://s3-alpha-sig.figma.com/img/fc2f/2f1c/898bdf2cb5cf0120237adce81ea30a40?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=YF3zF9Rv6YP1nFyFtFQALFhmqBE0y3zT4DY2F6Pc-aGpgTaIDegwQcYlA0I2e8-U3MAsIQi5ZM7gZ0kf0JLGZWXOuzFnVJsWQzn4qdg7OjMjV4ArNS40eNVzGWurnJQUI7uXqMwRvkYRm1raLtHkaXK-EkpAEx5lTBvvjxhpmlEFZW~qy1Fbc4W~od-i~5KlPObbA78GzeN1Rxl22UtufuyC0Ei24xdX53J8inrrshLSZmPJ8hxJdwlWyhBfGfMim7UZBGoQrJAJuZ4XvE5jgZqfplNzfaqheYenxiWz5d6O283UXw1ZaH2dV3atPRvqp8aNPMSTpwGaNeTMzX-Y3w__",
                name = "Дэн Браун"
            )
        )
    )