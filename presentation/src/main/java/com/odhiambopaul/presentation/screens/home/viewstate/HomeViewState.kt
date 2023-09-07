package com.odhiambopaul.presentation.screens.home.viewstate

import com.odhiambopaul.presentation.models.HomeUI

data class HomeViewState(
    val animeList: List<HomeUI> = emptyList()
)