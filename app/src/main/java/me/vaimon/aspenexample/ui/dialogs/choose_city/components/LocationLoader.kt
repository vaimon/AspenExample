package me.vaimon.aspenexample.ui.dialogs.choose_city.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.vaimon.aspenexample.utill.Resource

@Composable
fun <T> LocationLoader(
    data: Resource<List<T>>,
    onItemSelected: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    when (data) {
        is Resource.Error ->
            ErrorText(
                text = data.exception.localizedMessage,
                modifier = modifier
            )

        is Resource.Loading ->
            CircularProgressIndicator(
                modifier = modifier
            )

        is Resource.Success ->
            LocationsList(
                states = data.data,
                onItemSelected = onItemSelected,
                modifier = modifier
            )
    }
}