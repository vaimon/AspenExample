package me.vaimon.aspenexample.ui.screens.details.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.data.datasource.SampleDataSource
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.ui.util.PreviewMediumScreen
import me.vaimon.aspenexample.ui.util.SampleData

@Composable
fun ExpandableText(
    description: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 4,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
){
    var shouldOverflow by remember{ mutableStateOf(false) }

    var expanded by remember { mutableStateOf(false) }
    
    Column(
        modifier = modifier
    ){
        Text(
            text = description,
            style = textStyle,
            maxLines = if(expanded) Int.MAX_VALUE else maxLines,
            softWrap = true,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = {
                shouldOverflow = shouldOverflow || it.isLineEllipsized(it.lineCount - 1)
            },
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        )

        if(shouldOverflow){
            Spacer(modifier = Modifier.height(9.dp))
            ShowMoreButton(
                isExpanded = expanded,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    expanded = !expanded
                }
            )
        }
    }

}

@Composable
fun ShowMoreButton(
    isExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    val iconRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        label = "iconRotation",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = if(isExpanded) stringResource(R.string.label_hide) else stringResource(R.string.label_read_more),
            style = MaterialTheme.typography.labelMedium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.animateContentSize(),
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            painter = painterResource(id = R.drawable.icon_open),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.rotate(iconRotation)
        )
    }
}

@PreviewMediumScreen
@Composable
fun PreviewShowMoreBig(
    modifier: Modifier = Modifier
) {
    AspenExampleTheme {
        Surface {
            ExpandableText(
                description = SampleData.hotels[0].description,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@PreviewMediumScreen
@Composable
fun PreviewShowMoreLittle(
    modifier: Modifier = Modifier
) {
    AspenExampleTheme {
        Surface(
        ) {
            ExpandableText(
                description = SampleData.hotels[2].description,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}