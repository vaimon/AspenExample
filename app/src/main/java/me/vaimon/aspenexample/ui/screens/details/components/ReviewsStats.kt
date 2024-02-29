package me.vaimon.aspenexample.ui.screens.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.DirtyYellow

@Composable
fun ReviewsStats(
    rating: Double,
    reviewsCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ){
        Icon(
            painter = painterResource(id = R.drawable.icon_star),
            contentDescription = null,
            tint = DirtyYellow
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = stringResource(R.string.full_reviews_description, rating, reviewsCount),
            style = MaterialTheme.typography.labelSmall
        )
    }
}