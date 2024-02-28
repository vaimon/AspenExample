package me.vaimon.aspenexample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.navigation.NavigationDestination
import me.vaimon.aspenexample.ui.common.CompositeHeader
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.theme.Gray
import me.vaimon.aspenexample.util.PreviewMediumScreen

object HomeDestination : NavigationDestination {
    override val route = "home"
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToDetails: () -> Unit
) {
    val scrollState = rememberScrollState()
    Scaffold {
        HomeBody(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBody(
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(vertical = 40.dp)) {
        val padding = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
        Row(
            modifier = padding,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CompositeHeader(
                headerText = stringResource(R.string.aspen),
                secondaryHeaderText = stringResource(R.string.explore),
                headerSize = 32.sp,
                secondaryHeaderSize = 14.sp
            )
            CurrentLocationLabel()
        }
        Spacer(modifier = Modifier.height(24.dp))
        SearchField(modifier = padding)
        Spacer(modifier = Modifier.height(32.dp))
        CategoryRow(
            listOf("Location", "Hotels", "Food", "Adventure", "Accommodation")
        )
    }
}

@Composable
fun CategoryRow(
    categories: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 20.dp),
        modifier = modifier
    ) {
        itemsIndexed(categories) { index, item ->
            val isSelected = index == selectedCategoryIndex
            FilterChip(
                selected = isSelected,
                onClick = { selectedCategoryIndex = index },
                label = {
                    Text(
                        item,
                        style = if (isSelected)
                            MaterialTheme.typography.labelMedium
                        else
                            MaterialTheme.typography.bodySmall,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(
                            horizontal = 0.dp,
                            vertical = 12.dp
                        ),
                    )
                },
                shape = RoundedCornerShape(33.dp),
                border = null,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    selectedContainerColor = MaterialTheme.colorScheme.surface,
                    selectedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

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

@Composable
fun CurrentLocationLabel(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_location),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(R.string.location_default),
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_open),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null
        )
    }
}

@PreviewMediumScreen
@Composable
fun PreviewHome() {
    AspenExampleTheme {
        Scaffold {
            HomeBody(
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            )
        }
    }
}