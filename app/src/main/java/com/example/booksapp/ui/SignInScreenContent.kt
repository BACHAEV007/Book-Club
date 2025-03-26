package com.example.booksapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.ui.component.BooksCarousel
import com.example.booksapp.ui.component.SignTextField

@Composable
fun SignInScreenContent(
    modifier: Modifier = Modifier,
    onEnterClick: () -> Unit,
    isTesting: Boolean = true
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val emailCheck = remember { derivedStateOf { email.isNotEmpty() } }
    val passwordCheck = remember { derivedStateOf { password.isNotEmpty() } }
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp, bottom = 24.dp)) {
            BooksCarousel(modifier = Modifier.weight(1f), isTesting)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = stringResource(R.string.open_for_yourself).uppercase(),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .offset(y = (16).dp)
                        .testTag(SignInTestTags.SignInTextTestTag)
                )

                Text(
                    text = stringResource(R.string.book_world).uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
                Spacer(modifier = Modifier.size(24.dp))
                SignTextField(
                    hint = stringResource(R.string.email),
                    icon = painterResource(R.drawable.cross_icon),
                    value = email,
                    testTag = SignInTestTags.SignInEmailTestTag,
                    onValueChange = { email = it }
                )
                Spacer(modifier = Modifier.size(8.dp))
                SignTextField(
                    hint = stringResource(R.string.password),
                    icon = painterResource(R.drawable.eye_on_icon),
                    value = password,
                    testTag = SignInTestTags.SignInPasswordTestTag,
                    onValueChange = { password = it },
                    isPasswordField = true
                )
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    onClick = onEnterClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(SignInTestTags.SignInButtonTestTag),
                    shape = RoundedCornerShape(size = 100.dp),
                    contentPadding = PaddingValues(vertical = 15.dp),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor = MaterialTheme.colorScheme.tertiary,
                        disabledContainerColor = MaterialTheme.colorScheme.secondary
                    ),
                    enabled = emailCheck.value && passwordCheck.value
                ) {
                    Text(
                        text = stringResource(R.string.enter),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.testTag(SignInTestTags.SignInButtonTextTestTag)
                    )
                }
            }
        }

    }

}

@Preview
@Composable
fun SignInScreenContentPreview() {
    SignInScreenContent(onEnterClick = {})
}
