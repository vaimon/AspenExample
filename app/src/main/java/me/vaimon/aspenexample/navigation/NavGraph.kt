package me.vaimon.aspenexample.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.vaimon.aspenexample.ui.screens.details.DetailsDestination
import me.vaimon.aspenexample.ui.screens.details.DetailsScreen
import me.vaimon.aspenexample.ui.screens.details.DetailsViewModel
import me.vaimon.aspenexample.ui.screens.home.HomeDestination
import me.vaimon.aspenexample.ui.screens.home.HomeScreen
import me.vaimon.aspenexample.ui.screens.home.HomeViewModel
import me.vaimon.aspenexample.ui.screens.welcome.WelcomeDestination
import me.vaimon.aspenexample.ui.screens.welcome.WelcomeScreen
import me.vaimon.aspenexample.ui.screens.welcome.WelcomeViewModel

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
        val springAnimationSpec = spring<IntOffset>(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessLow
        )

        composable(route = WelcomeDestination.route) {
            val viewModel = hiltViewModel<WelcomeViewModel>()
            WelcomeScreen(
                viewModel = viewModel,
                navigateToHome = {
                    navController.navigate(HomeDestination.route) {
                        popUpTo(WelcomeDestination.route) {
                            inclusive = true
                        }
                    }

                }
            )
        }

        composable(
            route = HomeDestination.route,
            enterTransition = {
                scaleIn(
                    animationSpec = tween()
                )
            },
            ) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                viewModel = viewModel,
                navigateToDetails = { id ->
                    navController.navigate(DetailsDestination.getDestinationWithArg(id))
                },
            )
        }

        composable(
            route = DetailsDestination.route,
            arguments = listOf(
                navArgument(DetailsDestination.argName) {
                    type = NavType.IntType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = springAnimationSpec
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                    animationSpec = springAnimationSpec
                )
            }
        ) {
            val viewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(
                viewModel = viewModel,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}