package com.odhiambopaul.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.odhiambopaul.presentation.R
import com.odhiambopaul.presentation.common.PaddingSpace
import com.odhiambopaul.presentation.components.AnimeItem

@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = PaddingSpace.MediumPadding.dp,
                    vertical = PaddingSpace.MediumPadding.dp
                ), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(painter = painterResource(id = R.mipmap.menu), contentDescription = "drawer")
            Icon(painter = painterResource(id = R.mipmap.menu), contentDescription = "drawer")
        }
    }, content = {
        LazyVerticalGrid(
            modifier = Modifier.padding(it),
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(horizontal = PaddingSpace.SmallPadding.dp)
        ) {
            items(count = 20, itemContent = {
                AnimeItem()
            })
        }
    })
}