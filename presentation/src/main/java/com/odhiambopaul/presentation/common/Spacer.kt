package com.odhiambopaul.presentation.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SmallVSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.SmallPadding.dp))
}

@Composable
fun MediumVSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.MediumPadding.dp))
}

@Composable
fun LargeVSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.LargePadding.dp))
}

@Composable
fun ExtraLargeVSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.ExtraLargePadding.dp))
}

@Composable
fun SmallHSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.SmallPadding.dp))
}

@Composable
fun MediumHSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.MediumPadding.dp))
}

@Composable
fun LargeHSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.LargePadding.dp))
}

@Composable
fun ExtraLargeHSpace() {
    Spacer(modifier = Modifier.width(PaddingSpace.ExtraLargePadding.dp))
}