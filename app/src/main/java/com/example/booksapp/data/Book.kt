package com.example.booksapp.data

data class Book(
    val imageUrl: String,
    val author: String,
    val description: String,
    val title: String
)

val bookList = listOf(
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/c116/1776/f4ccba0316c0050e9df514629488db9c?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=TOGnxrNDEB7uZTsMIfdFfUQI4SKJ0pnNQ9M6KsLCASQh1lQdBp9H3i52IwDRXsnxoFAN9~ynMo0sGlgXwZGe2yX74uY4AZueWHLIY5ya7yAywqLh7CNP6AdlHB7pDif60GTswoI-Kg2Ib3~22EFKqKbkIMB1UBxO~bSyw79e6DV9UevRybckFmlj1jXTrS8sGlYuEHhzIGiUng02mpkMugtfRGi7-e8hu98wUuaWLxvJBwDkvXTwcM6cH8vxtkl6TyRSquAuMJaWeGfJIJGRvKUvpvpaHkIURaAR~4X5xSEOilRoKHdBUB1X83ehj~wS0RBVPNyTWBIKq~A~beuryA__",
        author = "Фёдор Достоевский",
        description = "Роман о вине и искуплении молодого человека.",
        title = "Преступление и наказание"

    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/6c14/f05b/ceec55a32a17da7a6043413eb5b90676?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=oqvS~ltSFUThuh7XRM-LBgFlg0XfFeuAOeadNOOxx36oAkIdZbEFu5jPctFmaDAbtatjSZeQGjf6ibHaq36vl8hX~ljlcJ5oVnVULPIUCnqKOYIVUHUlnE0ab6ww4Stzv-JbHA7aLIYp6Zc4o~f-aC8SONLlvHk~yNJ0eqoCGgeaPUPAJ63-ff4iBm49Rds3VSpxGvX4jUdM0MFvUiZ2zT3Re5XydVSWKg7T~PYQ9VicBQ2K~KDziFtKVr9aLbeMoeTmV1igJm1wZ6uPxX0mhfZLFk1b~fVj4itjG-hYXWbnCVYtcWFlpF7ZtS9kBV6xz1JwbzFcERAZMDdxe6NCmA__",
        author = "Дэн Браун",
        description = "Триллер о разгадке тайны, связанной с кодом Леонардо да Винчи",
        title = "Код Да Винчи"
    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/0446/04bb/7b64749960fbad16e7a2f549e14daaed?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=EVfQpRpCAlLijAJcmGCqn843321J1L3h~L~ZZpMRK0rD0bDcqr5Akk2o9pj879eNVa0SWUTPCkhSgRGf2oDPqz1K5vombzVeirsIwwZwJOG6MV38aCeZMQtpPI~TkfrCEuhBfocmuEKaQqVIOBVQIRcsWHztqZAhcZx5Q9FJKTIt6g2qS41vnMERE0mBJh2DogKQFDk~qkDG6QCj7WWuamEFR56ox0-9XQxrV2FXw5Z-D7LqUIClYhPS6BvvFp9R0WhFXnzN6rUtyIi~Mt52IHdC0HgoEfsv1fCrETOW0Jn3AsbUVEb2DScR2XNPuK23jcDqb1fkrzJEgpvYKA-iPw__",
        author = "Эрик Мария Ремарк",
        description = "Сборник рассказов про трёх товарищей.",
        title = "Три товарища"
    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/13a3/129c/67c7feceb336f371fc34862b2b1a571c?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=qyQPhdhSonryH8TyskKljykFLFRxTqnHne0pyLsG~Z4Ji3wQoXEvxxZIwSwVUJKHeVu26SVQbwF7csxps1oFegN5pumZUsmqPEYHbMWW4lJOOg3DuTcaM5YYEZUAR8gmCp9MF-mCz1Gx62-S3zwu9SkCK49BR1Iqbj~T2QA1d8Xl0BaD3uXeje1mQIRDC-DxjYVKUprfg5sHwrGILw9q-FmZVFR4uXeQfNtyQTLjMzrw~YXrxVJ98rQr8tP8YUKtDsxRGhdI6l5tEjzn-9eL~fkl4f6gg6OrmBzv3Iin5vSJxhI~JTLAMGgv6AoMGl8YO4oR0HPhrZLu3wjCUhnJEg__",
        author = "Михаил Булгаков",
        description = "Сатира с фантастикой о Москве.",
        title = "Мастер и Маргарита"
    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/c116/1776/f4ccba0316c0050e9df514629488db9c?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=TOGnxrNDEB7uZTsMIfdFfUQI4SKJ0pnNQ9M6KsLCASQh1lQdBp9H3i52IwDRXsnxoFAN9~ynMo0sGlgXwZGe2yX74uY4AZueWHLIY5ya7yAywqLh7CNP6AdlHB7pDif60GTswoI-Kg2Ib3~22EFKqKbkIMB1UBxO~bSyw79e6DV9UevRybckFmlj1jXTrS8sGlYuEHhzIGiUng02mpkMugtfRGi7-e8hu98wUuaWLxvJBwDkvXTwcM6cH8vxtkl6TyRSquAuMJaWeGfJIJGRvKUvpvpaHkIURaAR~4X5xSEOilRoKHdBUB1X83ehj~wS0RBVPNyTWBIKq~A~beuryA__",
        author = "Фёдор Достоевский",
        description = "Роман о вине и искуплении молодого человека.",
        title = "Преступление и наказание"

    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/6c14/f05b/ceec55a32a17da7a6043413eb5b90676?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=oqvS~ltSFUThuh7XRM-LBgFlg0XfFeuAOeadNOOxx36oAkIdZbEFu5jPctFmaDAbtatjSZeQGjf6ibHaq36vl8hX~ljlcJ5oVnVULPIUCnqKOYIVUHUlnE0ab6ww4Stzv-JbHA7aLIYp6Zc4o~f-aC8SONLlvHk~yNJ0eqoCGgeaPUPAJ63-ff4iBm49Rds3VSpxGvX4jUdM0MFvUiZ2zT3Re5XydVSWKg7T~PYQ9VicBQ2K~KDziFtKVr9aLbeMoeTmV1igJm1wZ6uPxX0mhfZLFk1b~fVj4itjG-hYXWbnCVYtcWFlpF7ZtS9kBV6xz1JwbzFcERAZMDdxe6NCmA__",
        author = "Дэн Браун",
        description = "Триллер о разгадке тайны, связанной с кодом Леонардо да Винчи",
        title = "Код Да Винчи"
    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/0446/04bb/7b64749960fbad16e7a2f549e14daaed?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=EVfQpRpCAlLijAJcmGCqn843321J1L3h~L~ZZpMRK0rD0bDcqr5Akk2o9pj879eNVa0SWUTPCkhSgRGf2oDPqz1K5vombzVeirsIwwZwJOG6MV38aCeZMQtpPI~TkfrCEuhBfocmuEKaQqVIOBVQIRcsWHztqZAhcZx5Q9FJKTIt6g2qS41vnMERE0mBJh2DogKQFDk~qkDG6QCj7WWuamEFR56ox0-9XQxrV2FXw5Z-D7LqUIClYhPS6BvvFp9R0WhFXnzN6rUtyIi~Mt52IHdC0HgoEfsv1fCrETOW0Jn3AsbUVEb2DScR2XNPuK23jcDqb1fkrzJEgpvYKA-iPw__",
        author = "Эрик Мария Ремарк",
        description = "Сборник рассказов про трёх товарищей.",
        title = "Три товарища"
    ),
    Book(
        imageUrl = "https://s3-alpha-sig.figma.com/img/13a3/129c/67c7feceb336f371fc34862b2b1a571c?Expires=1743984000&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=qyQPhdhSonryH8TyskKljykFLFRxTqnHne0pyLsG~Z4Ji3wQoXEvxxZIwSwVUJKHeVu26SVQbwF7csxps1oFegN5pumZUsmqPEYHbMWW4lJOOg3DuTcaM5YYEZUAR8gmCp9MF-mCz1Gx62-S3zwu9SkCK49BR1Iqbj~T2QA1d8Xl0BaD3uXeje1mQIRDC-DxjYVKUprfg5sHwrGILw9q-FmZVFR4uXeQfNtyQTLjMzrw~YXrxVJ98rQr8tP8YUKtDsxRGhdI6l5tEjzn-9eL~fkl4f6gg6OrmBzv3Iin5vSJxhI~JTLAMGgv6AoMGl8YO4oR0HPhrZLu3wjCUhnJEg__",
        author = "Михаил Булгаков",
        description = "Сатира с фантастикой о Москве.",
        title = "Мастер и Маргарита"
    )
)
