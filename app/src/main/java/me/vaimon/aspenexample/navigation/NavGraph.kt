package me.vaimon.aspenexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.vaimon.aspenexample.ui.screens.home.HomeDestination
import me.vaimon.aspenexample.ui.screens.home.HomeScreen
import me.vaimon.aspenexample.ui.screens.home.HomeViewModel
import me.vaimon.aspenexample.ui.screens.welcome.WelcomeDestination
import me.vaimon.aspenexample.ui.screens.welcome.WelcomeScreen
import me.vaimon.aspenexample.ui.screens.welcome.WelcomeViewModel

interface NavigationDestination {
    val route: String
}

@Composable
fun AspenNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = WelcomeDestination.route,
        modifier = modifier
    ) {
        composable(route = WelcomeDestination.route) {
            val viewModel = hiltViewModel<WelcomeViewModel>()
            WelcomeScreen(
                viewModel = viewModel,
                navigateToHome = {
                    navController.navigate(HomeDestination.route)
                }
            )
        }

        composable(route = HomeDestination.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                viewModel = viewModel,
                navigateToDetails = { }
            )
        }
    }
}