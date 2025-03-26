package com.example.booksapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booksapp.R

@Composable
fun SignTextField(
    modifier: Modifier = Modifier,
    hint: String,
    icon: Painter,
    isPasswordField: Boolean = false,
    value: String,
    testTag: String = "",
    onValueChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(!isPasswordField) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.secondary
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            textStyle = MaterialTheme.typography.bodySmall,
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
                disabledTextColor = MaterialTheme.colorScheme.tertiary,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.secondary,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = hint,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodySmall
                )
            },
            modifier = Modifier.weight(1f).testTag(testTag)
        )
        if (value != "") {
            Image(painter = when {
                isPasswordField && passwordVisible -> painterResource(R.drawable.eye_on_icon)
                isPasswordField && !passwordVisible -> painterResource(R.drawable.eye_off_icon)
                else -> icon
            },
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary),
                modifier = if (!isPasswordField) Modifier
                    .padding(end = 16.dp)
                    .clickable { onValueChange("") } else Modifier
                    .padding(end = 16.dp)
                    .clickable { passwordVisible = !passwordVisible })
        }

    }
}

//@Preview
//@Composable
//fun SignTextFieldPreview() {
//    SignTextField(hint = "Электронная почта", icon = painterResource(R.drawable.cross_icon))
//}