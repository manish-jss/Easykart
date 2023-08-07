package com.sample.easykart.ui.screens.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.easykart.data.model.ProductItem
import com.sample.easykart.data.reprository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle, private val repository: ProductRepository) : ViewModel() {
    val productDetail: StateFlow<ProductItem?>
        get() = repository.productDetail

    init {
        val argument = savedStateHandle.get<String>("id").orEmpty()
        viewModelScope.launch {
            repository.getProductDetail(argument)
        }
    }

}