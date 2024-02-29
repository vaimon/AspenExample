package me.vaimon.aspenexample.ui.common

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.Gray
import me.vaimon.aspenexample.ui.theme.LightGray
import me.vaimon.aspenexample.ui.theme.Red

@Composable
fun FavouriteButton(
    onChecked: () -> Unit,
    iconSize: Dp,
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
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_like),
            contentDescription = null,
            modifier = Modifier.size(iconSize)
        )
    }
}