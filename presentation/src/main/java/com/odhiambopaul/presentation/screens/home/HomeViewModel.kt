package com.odhiambopaul.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odhiambopaul.domain.models.Anime
import com.odhiambopaul.domain.repository.AnimeRepository
import com.odhiambopaul.domain.work.SyncDataWorkManager
import com.odhiambopaul.presentation.models.HomeUI
import com.odhiambopaul.presentation.screens.home.viewstate.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository,
    private val syncDataWorkManager: SyncDataWorkManager
) : ViewModel() {

    val isSyncing = syncDataWorkManager.isSyncing
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = false
        )

    fun startRefresh() {
        viewModelScope.launch {
            syncDataWorkManager.startSync()
        }
    }

    private fun List<Anime>.toAnimePresentation() =
        map {
            HomeUI(
                imageUrl = it.url,
                name = it.title,
                tagline = it.title,
                embedUrl = it.embedUrl,
                trailerUrl = it.trailerUrl

            )
        }

    val viewState: StateFlow<HomeViewState> = animeRepository.fetchTopAnime()
        .map {
            HomeViewState(
                animeList = it.toAnimePresentation()
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = HomeViewState()
        )

}