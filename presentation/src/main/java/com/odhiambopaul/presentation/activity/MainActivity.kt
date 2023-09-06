package com.odhiambopaul.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.odhiambopaul.presentation.navigation.BottomNav
import com.odhiambopaul.presentation.navigation.NavigationGraph
import com.odhiambopaul.presentation.navigation.Route
import com.odhiambopaul.presentation.theme.AnimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)



        setContent {
            AnimeTheme {
                val navController = rememberNavController()
                val isMainScreen = rememberSaveable { mutableStateOf(false) }
                val navStackBackEntry by navController.currentBackStackEntryAsState()
                isMainScreen.value = when (navStackBackEntry?.destination?.route) {
                    Route.HomeRoute.route -> true
                    Route.FavoriteRoute.route -> true
                    Route.ProfileRoute.route -> true
                    else -> false
                }
                Surface(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            AnimatedVisibility(visible = true, exit = fadeOut(), enter = fadeIn()) {
                                if (isMainScreen.value) BottomNav(navController = navController)
                            }
                        }
                    ) {
                        NavigationGraph(navController)
                    }
                }
            }
        }
    }
}