package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.Stage

@Composable
fun StagesCustomMenu(
    modifier: Modifier = Modifier,
    stages: List<Stage>,
    current: Int,
    hideMenu: () -> Unit,
    onStageClick: (index: Int) -> Unit
) {
    val widthFraction = 320f / 412f
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                onClick = { hideMenu() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(widthFraction)
                .fillMaxHeight()
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp),
                    clip = false
                )
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                )
                .align(Alignment.CenterEnd)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .padding(start = 16.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.tables).uppercase(),
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(12.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.cross_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable { hideMenu() }
                    )
                }

            }
            LazyColumn(
                modifier = modifier
                    .weight(1f)
                    .background(
                        MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                    )
            ) {
                itemsIndexed(stages) { index, stage ->
                    Text(
                        text = stage.name,
                        style = if (index == current) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 13.5.dp, horizontal = 16.dp)
                            .clickable { onStageClick(index) }
                    )
                }

            }
            Spacer(modifier = Modifier.size(24.dp))
        }

    }
}

