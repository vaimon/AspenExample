package me.vaimon.aspenexample.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.data.SampleData
import me.vaimon.aspenexample.navigation.NavigationDestination
import me.vaimon.aspenexample.ui.common.CompositeHeader
import me.vaimon.aspenexample.ui.models.Hotel
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.theme.Gray
import me.vaimon.aspenexample.ui.theme.LightGray
import me.vaimon.aspenexample.ui.theme.Red
import me.vaimon.aspenexample.ui.theme.Yellow
import me.vaimon.aspenexample.ui.theme.labelSmallChip
import me.vaimon.aspenexample.ui.theme.labelSmallVariant
import me.vaimon.aspenexample.util.PreviewMediumScreen
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

object HomeDestination : NavigationDestination {
    override val route = "home"
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToDetails: () -> Unit
) {
    val hotels by viewModel.hotelsState.collectAsState()
    val scrollState = rememberScrollState()
    Scaffold {
        HomeBody(
            hotels,
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
    hotels: List<Hotel>,
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
        Spacer(modifier = Modifier.height(32.dp))
        TitleRow(
            titleText = "Popular",
            titleActionLabel = "See all",
            titleAction = {},
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(hotels) {
                LargeHotelCard(
                    it,
                    modifier = Modifier.height(240.dp)
                )
            }
        }
    }
}

@Composable
fun LargeHotelCard(
    hotel: Hotel,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier.aspectRatio(0.77f)
    ) {
        Image(
            painter = painterResource(id = hotel.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            RatingTitle(
                hotel.name,
                hotel.rating,
                Modifier.weight(1f)
            )
            FavouriteButton(
                onChecked = {},
                modifier = Modifier.padding(bottom = 16.dp, end = 16.dp)
            )
        }
    }
}

@Composable
fun FavouriteButton(
    onChecked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checked by remember { mutableStateOf(true) }
    IconToggleButton(
        checked = checked,
        onCheckedChange = {
            checked = !checked
            onChecked()
        },
        colors = IconToggleButtonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = LightGray,
            disabledContainerColor = LightGray,
            disabledContentColor = Gray,
            checkedContainerColor = MaterialTheme.colorScheme.background,
            checkedContentColor = Red
        ),
        modifier = modifier.size(24.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_like),
            contentDescription = null,
            modifier = Modifier.size(10.dp)
        )
    }
}

@Composable
fun RatingTitle(
    titleText: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    val backgroundModifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.surfaceVariant)
    Column(
        modifier.padding(12.dp)
    ) {
        Text(
            text = titleText,
            style = MaterialTheme.typography.labelSmallChip,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = backgroundModifier
                .padding(vertical = 4.dp, horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = backgroundModifier
                .padding(vertical = 4.dp, horizontal = 10.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icon_star),
                contentDescription = null,
                tint = Yellow
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = DecimalFormat("#.#", DecimalFormatSymbols(Locale.US)).format(rating),
                style = MaterialTheme.typography.labelSmallChip,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
fun TitleRow(
    titleText: String,
    modifier: Modifier = Modifier,
    titleActionLabel: String? = null,
    titleAction: (() -> Unit)? = null,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = titleText,
            style = MaterialTheme.typography.headlineMedium
        )
        titleActionLabel?.let { label ->
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmallVariant,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { titleAction?.invoke() }
            )
        }
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
                SampleData.hotels,
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            )
        }
    }
}