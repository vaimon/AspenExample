package me.vaimon.aspenexample.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    icon: (@Composable RowScope.() -> Unit)? = null,
) = Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(),
    contentPadding = PaddingValues(
        horizontal = 44.dp,
        vertical = 16.dp
    ),
    shape = shape,
    modifier = modifier
){
    Text(
        text = buttonText,
        style = MaterialTheme.typography.labelMedium,
    )
    icon?.invoke(this)
}