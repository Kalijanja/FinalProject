package net.simplifiedcoding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.data.utils.AdventScreen
import net.simplifiedcoding.data.utils.AnimScreen
import net.simplifiedcoding.data.utils.BeautifulScreen
import net.simplifiedcoding.data.utils.BikeScreen
import net.simplifiedcoding.data.utils.ButterflyScreen
import net.simplifiedcoding.data.utils.FisherScreen
import net.simplifiedcoding.data.utils.LeafyScreen
import net.simplifiedcoding.data.utils.MilesScreen
import net.simplifiedcoding.data.utils.NatureScreen
import net.simplifiedcoding.data.utils.SceneryScreen
import net.simplifiedcoding.data.utils.SeaSideScreen
import net.simplifiedcoding.data.utils.SeaViewScreen
import net.simplifiedcoding.data.utils.SpaceyScreen
import net.simplifiedcoding.data.utils.SpideyScreen
import net.simplifiedcoding.data.utils.TatScreen
import net.simplifiedcoding.data.utils.TearDropScreen
import net.simplifiedcoding.data.utils.ViewScreen
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.auth.LoginScreen
import net.simplifiedcoding.ui.auth.SignupScreen
import net.simplifiedcoding.ui.home.HomeScreen
import net.simplifiedcoding.ui.home.ProfileScreen
import net.simplifiedcoding.ui.splashScreen.splashScreen

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
        composable(ROUTE_PROFILE) {
            ProfileScreen(viewModel, navController)
        }
        composable(ROUTE_SPLASH) {
            splashScreen(navController)
        }
        composable(ROUTE_LEAFY) {
            LeafyScreen(viewModel, navController)
        }
        composable(ROUTE_BUTTERFLY) {
            ButterflyScreen(viewModel, navController)
        }
        composable(ROUTE_SPACEY) {
            SpaceyScreen(viewModel, navController)
        }
        composable(ROUTE_SCENERY) {
            SceneryScreen(viewModel, navController)
        }
        composable(ROUTE_TEARDROP) {
            TearDropScreen(viewModel, navController)
        }
        composable(ROUTE_SEASIDE) {
            SeaSideScreen(viewModel, navController)
        }
        composable(ROUTE_SEAVIEW) {
            SeaViewScreen(viewModel, navController)
        }
        composable(ROUTE_ADVENT) {
            AdventScreen(viewModel, navController)
        }
        composable(ROUTE_ANIM) {
            AnimScreen(viewModel, navController)
        }
        composable(ROUTE_BEAUTI) {
            BeautifulScreen(viewModel, navController)
        }
        composable(ROUTE_BIKE) {
            BikeScreen(viewModel, navController)
        }
        composable(ROUTE_MILES) {
            MilesScreen(viewModel, navController)
        }
        composable(ROUTE_NATURE) {
            NatureScreen(viewModel, navController)
        }
        composable(ROUTE_SPIDEY) {
            SpideyScreen(viewModel, navController)
        }
        composable(ROUTE_TAT) {
            TatScreen(viewModel, navController)
        }
        composable(ROUTE_VIEW) {
            ViewScreen(viewModel, navController)
        }
        composable(ROUTE_FISHER) {
            FisherScreen(viewModel, navController)
        }
    }
}