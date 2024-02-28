package me.vaimon.aspenexample.ui.screens.home.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.Gray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    SearchBar(
        query = searchQuery,
        onQueryChange = { searchQuery = it },
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_search),
                contentDescription = null,
                tint = Gray
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search_label),
                style = MaterialTheme.typography.bodySmall,
                color = Gray
            )
        },
        shape = RoundedCornerShape(24.dp),
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        tonalElevation = 0.dp,
        modifier = modifier
    ) {

    }
}