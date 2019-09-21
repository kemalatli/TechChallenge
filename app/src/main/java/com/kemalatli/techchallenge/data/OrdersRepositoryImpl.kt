package com.kemalatli.techchallenge.data

import com.kemalatli.techchallenge.domain.OrdersRepository
import com.kemalatli.techchallenge.model.Order
import io.reactivex.Single
import retrofit2.Retrofit

class OrdersRepositoryImpl(private val retrofit: Retrofit):OrdersRepository {

    private val orderService :OrderService by lazy { retrofit.create(OrderService::class.java)}

    override fun getOrders(): Single<List<Order>> = orderService.getListOfOrders()

}