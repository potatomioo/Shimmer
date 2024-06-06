package com.example.shimmer.ui.theme

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun animateshimmer() {
    val shimmer = listOf(
        Color.Black.copy(alpha = .7f),
        Color.Black.copy(alpha = .2f),
        Color.Black.copy(alpha = .7f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnime = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmer,
        start = Offset.Zero,
        end = Offset(x = translateAnime.value, y = translateAnime.value)
    )

    ShimmerGridItem(brush)

}


@Composable
fun ShimmerGridItem(
    brush : Brush
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(brush)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxSize(0.8f)
                .background(brush)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxSize(0.8f)
                .background(brush)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ShimmerPrev() {
    ShimmerGridItem(
        brush = Brush.linearGradient(
            listOf(
                Color.Black.copy(alpha = .7f),
                Color.Black.copy(alpha = .2f),
                Color.Black.copy(alpha = .7f)
            )
        )
    )
}