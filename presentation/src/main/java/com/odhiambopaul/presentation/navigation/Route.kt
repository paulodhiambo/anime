package com.odhiambopaul.presentation.navigation

sealed class Route(val route: String) {
    object HomeRoute : Route("home")
    object FavoriteRoute : Route("favorite")
    object ProfileRoute : Route("profile")
    object DetailRoute : Route("detail")
    object AddImageRoute : Route("add_image")
}