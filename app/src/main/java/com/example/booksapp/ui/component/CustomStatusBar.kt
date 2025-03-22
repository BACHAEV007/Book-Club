package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomStatusBar(modifier: Modifier = Modifier, percent: Float = 16f) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)) {
        if (percent >= 0.1f){
            Box(
                modifier = Modifier
                    .weight(percent)
                    .height(4.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(24.dp)
                    )
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        if (100f - percent > 0.1){
            Box(
                modifier = Modifier
                    .weight(100f - percent)
                    .height(4.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(24.dp)
                    )
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(4.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(24.dp)
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomStatusBarPreview() {
    CustomStatusBar()
}


