package com.kemalatli.techchallenge.data

import com.kemalatli.techchallenge.model.Order
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface OrderService{

    @Headers("Content-Type: application/json")
    @GET(".")
    fun getListOfOrders(): Single<List<Order>>

}