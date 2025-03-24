package com.example.booksapp.ui.component

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booksapp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun BottomSheetContent(
    onCloseClick: () -> Unit,
    fontSize: Float,
    onFontSizeChange: (Float) -> Unit,
    lineSpacing: Float,
    onLineSpacingChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var typeface = try {
        Typeface.createFromAsset(context.assets, "font/velasans_regular.ttf")
    } catch (e: Exception) {
        Typeface.DEFAULT
    } finally {
        Typeface.DEFAULT
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 19.dp, start = 16.dp, end = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.settings).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = onCloseClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.cross_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Text(
            text = stringResource(R.string.font_size),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        val isDragged by interactionSource.collectIsDraggedAsState()


        Slider(
            value = fontSize,
            onValueChange = onFontSizeChange,
            valueRange = 9f..19f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 27.dp, end = 8.dp),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondary,
                activeTickColor = MaterialTheme.colorScheme.primary
            ),
            steps = 9,
            interactionSource = interactionSource,
            thumb = {
                val primaryColor = MaterialTheme.colorScheme.primary
                val onPrimaryColor = MaterialTheme.colorScheme.onPrimary

                SliderDefaults.Thumb(
                    interactionSource = interactionSource,
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = if (isDragged || isPressed) Modifier
                        .drawBehind {
                            val rectWidth = 48.dp.toPx()
                            val rectHeight = 44.dp.toPx()
                            val offsetY = -rectHeight - 4.dp.toPx()
                            val centerX = size.width / 2
                            val centerY = offsetY + rectHeight / 2

                            val topLeft = Offset(
                                x = centerX - (rectWidth / 2),
                                y = offsetY
                            )

                            drawRoundRect(
                                color = primaryColor,
                                topLeft = topLeft,
                                size = Size(rectWidth, rectHeight),
                                cornerRadius = CornerRadius(100.dp.toPx())
                            )

                            val text = fontSize.toInt().toString()
                            val textPaint = Paint().apply {
                                color = onPrimaryColor.toArgb()
                                textSize = 14.dp.toPx()
                                textAlign = android.graphics.Paint.Align.CENTER
                                typeface = Typeface.create(typeface, Typeface.NORMAL)
                            }
                            drawIntoCanvas { canvas ->
                                canvas.nativeCanvas.drawText(
                                    text,
                                    centerX,
                                    centerY + (textPaint.textSize / 3),
                                    textPaint
                                )
                            }
                        } else Modifier
                )


            }
        )

        Text(
            text = stringResource(R.string.text_align),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        val interactionSourceAlign = remember { MutableInteractionSource() }
        val isPressedAlign by interactionSourceAlign.collectIsPressedAsState()
        val isDraggedAlign by interactionSourceAlign.collectIsDraggedAsState()
        Slider(
            value = lineSpacing,
            onValueChange = onLineSpacingChange,
            valueRange = 0.75f..2.25f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondary,
                activeTickColor = MaterialTheme.colorScheme.primary
            ),
            steps = 9,
            interactionSource = interactionSourceAlign,
            thumb = {
                val primaryColor = MaterialTheme.colorScheme.primary
                val onPrimaryColor = MaterialTheme.colorScheme.onPrimary

                SliderDefaults.Thumb(
                    interactionSource = interactionSourceAlign,
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = if (isDraggedAlign || isPressedAlign) Modifier
                        .drawBehind {
                            val rectWidth = 48.dp.toPx()
                            val rectHeight = 44.dp.toPx()
                            val offsetY = -rectHeight - 4.dp.toPx()
                            val centerX = size.width / 2
                            val centerY = offsetY + rectHeight / 2

                            val topLeft = Offset(
                                x = centerX - (rectWidth / 2),
                                y = offsetY
                            )

                            drawRoundRect(
                                color = primaryColor,
                                topLeft = topLeft,
                                size = Size(rectWidth, rectHeight),
                                cornerRadius = CornerRadius(100.dp.toPx())
                            )

                            val roundedLineSpacing = (lineSpacing * 100).toInt().toFloat() / 100
                            val text = roundedLineSpacing.toString()
                            val textPaint = Paint().apply {
                                color = onPrimaryColor.toArgb()
                                textSize = 14.dp.toPx()
                                textAlign = android.graphics.Paint.Align.CENTER
                                typeface = Typeface.create(typeface, Typeface.NORMAL)
                            }
                            drawIntoCanvas { canvas ->
                                canvas.nativeCanvas.drawText(
                                    text,
                                    centerX,
                                    centerY + (textPaint.textSize / 3),
                                    textPaint
                                )
                            }
                        } else Modifier
                )
            }
        )
    }
}