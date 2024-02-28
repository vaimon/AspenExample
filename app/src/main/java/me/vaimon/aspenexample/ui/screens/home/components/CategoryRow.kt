package me.vaimon.aspenexample.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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