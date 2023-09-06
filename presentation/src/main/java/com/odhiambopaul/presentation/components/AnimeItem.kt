package com.odhiambopaul.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.odhiambopaul.presentation.R
import com.odhiambopaul.presentation.common.PaddingSpace

@Composable
fun AnimeItem() {
    Image(
        painter = painterResource(id = R.mipmap.poster),
        contentDescription = "poster",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(horizontal = PaddingSpace.ExtraSmallPadding.dp)
            .padding(bottom = PaddingSpace.SmallPadding.dp)
    )
}