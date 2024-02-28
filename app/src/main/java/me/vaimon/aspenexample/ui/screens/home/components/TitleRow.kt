package me.vaimon.aspenexample.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.vaimon.aspenexample.ui.theme.labelSmallVariant

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