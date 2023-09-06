package com.odhiambopaul.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.odhiambopaul.presentation.screens.addimage.AddImageScreen
import com.odhiambopaul.presentation.screens.animedetail.AnimeDetailScreen
import com.odhiambopaul.presentation.screens.favorites.FavoriteScreen
import com.odhiambopaul.presentation.screens.home.HomeScreen
import com.odhiambopaul.presentation.screens.profile.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Route.HomeRoute.route) {
        composable(Route.HomeRoute.route) {
            HomeScreen()
        }
        composable(Route.FavoriteRoute.route) {
            FavoriteScreen()
        }
        composable(Route.ProfileRoute.route) {
            ProfileScreen()
        }
        composable(Route.DetailRoute.route) {
            AnimeDetailScreen()
        }
        composable(Route.AddImageRoute.route) {
            AddImageScreen()
        }
    }
}