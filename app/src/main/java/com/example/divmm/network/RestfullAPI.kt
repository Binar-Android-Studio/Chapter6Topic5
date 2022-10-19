package com.example.divmm.network

import com.example.divmm.model.responseProductItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfullAPI {
    @GET("products.json")
    fun getAllCar(): Call<List<responseProductItem>>
}