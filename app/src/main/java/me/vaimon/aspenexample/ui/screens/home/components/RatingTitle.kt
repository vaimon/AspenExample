package me.vaimon.aspenexample.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.Yellow
import me.vaimon.aspenexample.ui.theme.labelSmallChip
import me.vaimon.aspenexample.ui.util.formatRating
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun RatingTitle(
    titleText: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    val backgroundModifier = Modifier
        .clip(RoundedCornerShape(64.dp))
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
                text = formatRating(rating),
                style = MaterialTheme.typography.labelSmallChip,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}