package me.vaimon.aspenexample.ui.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R

@Composable
fun ExpandableText(
    description: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 4,
            softWrap = true,
            overflow = TextOverflow.Ellipsis
        )
    }
    Spacer(modifier = Modifier.height(9.dp))
    Row(
        verticalAlignment = Alignment.Bottom,
    ) {
        var baseline by remember { mutableFloatStateOf(0f) }
        val topBaselinePadding = with(LocalDensity.current) { baseline.toDp() }
        Text(
            text = "Read more",
            style = MaterialTheme.typography.labelMedium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.alignByBaseline(),
            onTextLayout = { baseline = it.size.height - it.lastBaseline}
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            painter = painterResource(id = R.drawable.icon_open),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = topBaselinePadding)
        )
    }
}