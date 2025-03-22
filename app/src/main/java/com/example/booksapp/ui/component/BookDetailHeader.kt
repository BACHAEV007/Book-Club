package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.booksapp.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BookDetailHeader(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    image: String,
    onReadClick: (Int) -> Unit = {},
    topBarPadding: Dp
) {
    var parentHeight by remember { mutableStateOf(0.dp) }
    var boxParentHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    var imageHeight by remember { mutableStateOf(0.dp) }
    Box(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight().onGloballyPositioned { coordinates ->
            parentHeight = with(density) { coordinates.size.height.toDp() }
            boxParentHeight = parentHeight + 24.dp
        }) {
        GlideImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(412f / 380f).onGloballyPositioned { coordinates ->
                    imageHeight = with(density) { coordinates.size.height.toDp() }
                }
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        ) {
            it.placeholder(R.drawable.cross_icon)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(parentHeight / 2)
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
        Box(
            modifier = Modifier
                .fillMaxWidth().height(imageHeight + 24.dp)
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .padding(top = topBarPadding)
                    .padding(16.dp),
                colors = IconButtonColors(
                    contentColor = MaterialTheme.colorScheme.surface,
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.back_ic),
                    contentDescription = null
                )
            }
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).align(Alignment.BottomCenter), horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Button(
                    onClick = { },
                    colors =ButtonColors(
                        contentColor = MaterialTheme.colorScheme.surface,
                        containerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor = MaterialTheme.colorScheme.surface,
                        disabledContainerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(50),
                    contentPadding = PaddingValues(
                        top = 15.dp,
                        bottom = 15.dp
                    ),
                    modifier = Modifier.weight(0.552f),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.play_icon),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Читать", style = MaterialTheme.typography.labelLarge)
                }
                Button(
                    onClick = { },
                    colors = ButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary,
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        disabledContentColor = MaterialTheme.colorScheme.primary,
                        disabledContainerColor = MaterialTheme.colorScheme.tertiary
                    ),
                    shape = RoundedCornerShape(50),
                    contentPadding = PaddingValues(
                        top = 15.dp,
                        bottom = 15.dp
                    ),
                    modifier = Modifier.weight(0.426f),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.favorites_bottom_ic),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("В избранное", style = MaterialTheme.typography.labelLarge)
                }
            }
        }
    }
}

@Preview
@Composable
fun BookDetailHeaderPreview() {
    BookDetailHeader(
        onBackClick = {},
        image = "https://s3-alpha-sig.figma.com/img/e11b/cb67/f5e3dc5e3a35431158e3ccca0bd40b5b?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NQfOYlq34HRq32ftA7l1I-Tdd~htEktlLHbe65jxe8LH52aGpj3TPA~SjnzRa22jXBOLlZntcTruX40udq9xp04GPgLZGgsr6YQ6fOO-YWAzfWaacmsHPt-Vjw~2bfw-2YighWpBsfvc5oHNxib4I947zBcLEQxRveribhFw-ZvU06FZ2jf7msdDTnpcDzAkwyJvcJ-aFPcRCDTR~thlfUOVyc69Iu4WHHKP0cHag87ASZv1SrG2cXjjoB9N7cjudcH5iql39HedvRw8cD9j-KEowWTXkvaUnfR6vT4RRF5kcMXVef202Z-IjFM8zypU9WtI1cb9OABFvt2VMwTMJw__",
        onFavoriteClick = { },
        onReadClick = {},
        topBarPadding = 32.dp
    )
}