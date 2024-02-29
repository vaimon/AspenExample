package me.vaimon.aspenexample.ui.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.Green
import me.vaimon.aspenexample.ui.theme.labelExtraBold
import me.vaimon.aspenexample.ui.theme.labelSmallVariant

@Composable
fun PriceLabel(
    price: Int,
    modifier: Modifier = Modifier
) = Column(
    modifier = modifier
) {
    Text(
        stringResource(R.string.label_price),
        style = MaterialTheme.typography.labelSmallVariant,
    )
    Text(
        stringResource(R.string.price, price),
        style = MaterialTheme.typography.labelExtraBold,
        color = Green
    )
}