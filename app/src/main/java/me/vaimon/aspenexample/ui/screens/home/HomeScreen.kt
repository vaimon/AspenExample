package me.vaimon.aspenexample.ui.screens.home

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import me.vaimon.aspenexample.ui.theme.VeryLightBlue
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
    var searchQuery by remember { mutableStateOf("") }
    Column(modifier.padding(vertical = 40.dp)) {
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

        }
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