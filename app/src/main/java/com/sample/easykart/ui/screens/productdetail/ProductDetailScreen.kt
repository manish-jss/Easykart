package com.sample.easykart.ui.screens.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.sample.easykart.R
import com.sample.easykart.data.model.ProductItem
import com.sample.easykart.data.model.Rating
import com.sample.easykart.ui.screens.RatingBar
import com.sample.easykart.ui.screens.productlist.ProductListViewModel
import com.sample.easykart.ui.theme.GREEN_DARK


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen() {
    val viewModel: ProductDetailViewModel = hiltViewModel()
    val productItem = viewModel.productDetail.collectAsState().value

    Column(modifier = Modifier.fillMaxWidth(1f)) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),

            ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(productItem?.image)
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
                text = productItem?.title ?: "",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1
            )
            Text(
                text = "RS ${productItem?.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = GREEN_DARK
            )
            Text(
                text = "Free Delivery",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.size(5.dp))
            RatingBar(
                rating = productItem?.rating?.rate ?: 0.0
            )
            Text(
                text = productItem?.description ?: "",
                style = MaterialTheme.typography.bodyMedium,
            )
        }

    }
}

@Preview
@Composable
fun PrevDetailScreen() {
    ProductDetailScreen()
}