package com.odhiambopaul.presentation.navigation

import com.odhiambopaul.presentation.R

sealed class BottomNavigationItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavigationItem("Home", R.mipmap.home, Route.HomeRoute.route)
    object Favorites :
        BottomNavigationItem("Favorites", R.mipmap.favorites, Route.FavoriteRoute.route)

    object Profile : BottomNavigationItem("Profile", R.mipmap.user, Route.ProfileRoute.route)
}