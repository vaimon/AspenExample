package me.vaimon.aspenexample.ui.dialogs.choose_city.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.ui.theme.DarkGray

@Composable
fun <T> LocationsList(
    states: List<T>,
    onItemSelected: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = (PaddingValues(vertical = 16.dp))
    ) {
        items(states) {
            Text(
                text = it.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = DarkGray,
                fontSize = 18.sp,
                modifier = Modifier
                    .clickable {
                        onItemSelected(it)
                    }
                    .padding(
                        vertical = 12.dp,
                        horizontal = 0.dp
                    )
                    .fillMaxWidth()
            )
        }
    }
}