package com.odhiambopaul.presentation.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.odhiambopaul.presentation.common.PaddingSpace
import com.odhiambopaul.presentation.components.AnimeItem

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeViewState by homeViewModel.viewState.collectAsStateWithLifecycle()
    val isSyncing by homeViewModel.isSyncing.collectAsStateWithLifecycle()

    Scaffold(content = {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = isSyncing),
            onRefresh = { homeViewModel.startRefresh() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                contentPadding = PaddingValues(horizontal = PaddingSpace.SmallPadding.dp)
            ) {
                items(count = 20, itemContent = {
                    AnimeItem()
                })
            }
        }
    })
}