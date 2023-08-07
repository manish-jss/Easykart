package com.sample.easykart.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sample.easykart.R
import com.sample.easykart.ui.theme.GREEN_DARK

@Composable
fun RatingBar(
    rating: Double
) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = GREEN_DARK)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.size(5.dp))
        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(Modifier.size(5.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_star_24),
            contentDescription = "",
            Modifier.size(10.dp),
            colorFilter = ColorFilter.tint(color = Color.White)
        )
        Spacer(Modifier.size(5.dp))
    }

}
