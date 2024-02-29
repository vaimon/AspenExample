package me.vaimon.aspenexample.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import me.vaimon.aspenexample.ui.theme.labelSmallVariant

@Composable
fun TitleWithAction(
    titleText: String,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    actionText: String? = null,
    actionStyle: TextStyle = MaterialTheme.typography.labelSmallVariant,
    action: (() -> Unit)? = null,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = titleText,
            style = titleStyle,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.weight(1f)
        )
        actionText?.let { label ->
            Text(
                text = label,
                style = actionStyle,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable { action?.invoke() }
            )
        }
    }
}