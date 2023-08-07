package com.sample.easykart.data.reprository

import com.sample.easykart.data.api.NetworkService
import com.sample.easykart.data.model.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class ProductRepository @Inject constructor(private val networkService: NetworkService) {

    private val _productList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productList: StateFlow<List<ProductItem>>
        get() = _productList

    private val _productDetail = MutableStateFlow<ProductItem?>(null)
    val productDetail: StateFlow<ProductItem?>
        get() = _productDetail


    suspend fun getProductList() {
        val response = networkService.getProductList()
        if (response.body() != null) {
            _productList.emit(response.body()!!)
        }
    }

    suspend fun getProductDetail(id: String) {
        val response = networkService.getProductDetail(id)
        if (response.body() != null) {
            _productDetail.emit(response.body()!!)
        }
    }

}
