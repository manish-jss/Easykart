package com.sample.easykart.ui.screens.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sample.composedemo.view.screen.ProductListItem
import com.sample.easykart.R
import com.sample.easykart.data.model.ProductItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(onDetailClick: (ProductItem) -> Unit) {
    val viewModel: ProductListViewModel = hiltViewModel()
    val listState = viewModel.productList.collectAsState()

    Column(modifier = Modifier) {

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(1f)
                )
            }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary
            )
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(listState.value.size) { it ->
                ProductListItem(productItem = listState.value[it], onDetailClick)
            }
        }

//        LazyColumn(content = {
//            items(listState.value) {
//                ProductListItem(productItem = it, onDetailClick)
//            }
//        })

    }

}