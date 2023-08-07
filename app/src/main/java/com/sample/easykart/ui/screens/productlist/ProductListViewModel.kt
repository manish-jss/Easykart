package com.sample.easykart.ui.screens.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.easykart.data.model.ProductItem
import com.sample.easykart.data.reprository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {
    val productList: StateFlow<List<ProductItem>>
        get() = repository.productList

    init {
        viewModelScope.launch {
            repository.getProductList()
        }
    }

}