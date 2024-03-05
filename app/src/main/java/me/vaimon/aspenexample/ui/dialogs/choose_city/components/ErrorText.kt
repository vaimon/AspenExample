package me.vaimon.aspenexample.ui.dialogs.choose_city.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.Gray

@Composable
fun ErrorText(
    text: String?,
    modifier: Modifier = Modifier
) {
    Text(
        text = text ?: stringResource(R.string.error_unknown),
        style = MaterialTheme.typography.bodyMedium,
        color = Gray,
        fontSize = 18.sp,
        modifier = modifier
    )
}