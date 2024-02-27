package me.vaimon.aspenexample.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.ui.theme.headlineLargeSecondary

@Composable
fun CompositeHeader(
    headerText: String,
    secondaryHeaderText: String,
    modifier: Modifier = Modifier,
    headerSize: TextUnit = 40.sp,
    secondaryHeaderSize: TextUnit = 24.sp,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
) {
    Column(modifier = modifier){
        Text(
            text = secondaryHeaderText,
            style = MaterialTheme.typography.headlineLargeSecondary,
            fontSize = secondaryHeaderSize,
            color = textColor,
        )
        Text(
            text = headerText,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = headerSize,
            color = textColor,
        )
    }
}