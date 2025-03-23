package com.example.booksapp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.booksapp.data.detailsData
import com.example.booksapp.ui.component.BottomSheetContent
import com.example.booksapp.ui.component.ChapterBottomBar
import com.example.booksapp.ui.component.ChapterHeader
import com.example.booksapp.ui.component.StagesCustomMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreenContent(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    var isStageMenuVisible by remember { mutableStateOf(false) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var fontSize by remember { mutableStateOf(14f) }
    var lineSpacing by remember { mutableStateOf(1f) }

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ChapterHeader(modifier = Modifier, onBackClick)
            Text(
                text = "Знаменитый куратор Жак Соньер, пошатыва\u0002ясь, прошел под сводчатой аркой Большой га\u0002лереи и устремился к первой попавшейся ему\n" +
                        "на глаза картине, полотну Караваджо. Ухватил\u0002ся руками за позолоченную раму и стал тянуть\n" +
                        "ее на себя, пока шедевр не сорвался со стены и\n" +
                        "не рухнул на семидесятилетнего старика Соньера, погребя его под собой.\n" +
                        "Как и предполагал Соньер, неподалеку с грохотом опустилась\n" +
                        "металлическая решетка, преграждающая доступ в этот зал. Пар\u0002кетный пол содрогнулся. Где-то завыла сирена игнализации.\n" +
                        "Несколько секунд куратор лежал неподвижно, хватая ртом\n" +
                        "воздух и пытаясь сообразить, на каком свете находится. Я все еще жив. Потом он выполз из-под полотна и начал судорожно ози\u0002раться в поисках места, где можно спрятаться.\n" +
                        "Голос прозвучал неожиданно близко:\n" +
                        "— Не двигаться.\n" +
                        "Стоявший на четвереньках куратор похолодел, потом медлен\u0002но обернулся. Всего в пятнадцати футах от него, за решеткой, высилась внушительная и грозная фигура его преследователя. Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
                        "белыми волосами",
                modifier = Modifier.weight(1f)
            )
            ChapterBottomBar(
                modifier = Modifier,
                onBackClick = { },
                onStagesClick = { isStageMenuVisible = !isStageMenuVisible },
                onForwardClick = { },
                onSettingsClick = { isBottomSheetVisible = !isBottomSheetVisible},
                onPlayClick = {}
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
                detailsData.currentStageIndex,
                hideMenu = { isStageMenuVisible = !isStageMenuVisible }
            )
        }
        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = { isBottomSheetVisible = false },
                sheetState = bottomSheetState,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                containerColor = MaterialTheme.colorScheme.background,
                scrimColor = Color.Transparent,
                dragHandle = {}
            ) {
                BottomSheetContent(
                    onCloseClick = { isBottomSheetVisible = false },
                    fontSize = fontSize,
                    onFontSizeChange = { fontSize = it },
                    lineSpacing = lineSpacing,
                    onLineSpacingChange = { lineSpacing = it }
                )
            }
        }
    }

}