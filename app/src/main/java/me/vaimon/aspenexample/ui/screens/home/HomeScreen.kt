package me.vaimon.aspenexample.ui.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.navigation.NavigationDestination

object HomeDestination : NavigationDestination {
    override val route = "home"
}

@Composable
fun HomeScreen() {
    Text(text = "Home, sweet home")
}