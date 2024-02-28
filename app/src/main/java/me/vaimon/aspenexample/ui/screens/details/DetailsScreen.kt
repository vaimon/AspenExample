package me.vaimon.aspenexample.ui.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import me.vaimon.aspenexample.navigation.NavigationDestination

object DetailsDestination : NavigationDestination {
    override val route = "details"
}
@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    navigateBack: () -> Unit
) {
    Text("Hello details")
}