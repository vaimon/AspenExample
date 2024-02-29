package me.vaimon.aspenexample.ui.screens.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.common.ActionButton
import me.vaimon.aspenexample.ui.screens.details.PriceLabel
import me.vaimon.aspenexample.ui.theme.ShadowBlue

@Composable
fun PriceBottomBar(
    price: Int,
    onBtnBookPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonShape = RoundedCornerShape(16.dp)

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 12.dp, bottom = 24.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
    ) {
        PriceLabel(price = price)
        Spacer(modifier = Modifier.width(56.dp))
        ActionButton(
            buttonText = stringResource(R.string.action_book),
            icon = {
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_arrow_right),
                    contentDescription = null
                )
            },
            shape = buttonShape,
            onClick = onBtnBookPressed,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    8.dp,
                    shape = buttonShape,
                    spotColor = ShadowBlue
                )
        )
    }
}