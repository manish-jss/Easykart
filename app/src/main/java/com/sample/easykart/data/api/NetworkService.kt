package com.sample.easykart.data.api

import com.sample.easykart.data.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("products?limit=20")
    suspend fun getProductList() : Response<List<ProductItem>>

    @GET("products/{product_id}")
    suspend fun getProductDetail(@Path("product_id") id: String) : Response<ProductItem>

}