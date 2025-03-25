package com.example.booksapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import com.example.booksapp.data.searchScreenData

@Composable
fun LastQueryItem(modifier: Modifier = Modifier, query: String, onClick:() -> Unit) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(8.dp)
            ).clickable { onClick() }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp)
        )
        {
            Icon(
                painter = painterResource(R.drawable.history_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = query,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(R.drawable.cross_search_ic),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}


//@Preview
//@Composable
//fun LastQueryItemPreview() {
//    LastQueryItem(query = "IOS")
//}