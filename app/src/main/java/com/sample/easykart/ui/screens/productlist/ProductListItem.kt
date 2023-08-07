package com.sample.composedemo.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.sample.easykart.R
import com.sample.easykart.data.model.ProductItem
import com.sample.easykart.data.model.Rating
import com.sample.easykart.ui.screens.RatingBar
import com.sample.easykart.ui.theme.GREEN_DARK

@Composable
fun ProductListItem(productItem: ProductItem, onDetailClick: (productItem: ProductItem) -> Unit) {

    Card(
        modifier = Modifier
            .padding(5.dp)
            .clickable { onDetailClick(productItem) },
        elevation =  CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {

            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(productItem.image)
                    .size(Size.ORIGINAL) // Set the target size to load the image at.
                    .build()
            )
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.0f, true)
                    .background(color = Color.LightGray)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = productItem.title,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1
            )
            Text(
                text = "RS ${productItem.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = GREEN_DARK
            )
            Text(
                text = "Free Delivery",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.size(5.dp))
            RatingBar(
                rating = productItem.rating.rate
            )
        }
    }
}


@Composable
fun PrevCardListItem() {
    ProductListItem(
        productItem = ProductItem(
            "1",
            "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            1,
            "https://via.placeholder.com/600/92c952",
            100.0,
            Rating(10, 3.5),
            "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
        ),
        onDetailClick = { }
    )
}