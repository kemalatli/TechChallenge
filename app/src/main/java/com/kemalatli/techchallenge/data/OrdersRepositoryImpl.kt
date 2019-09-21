package com.kemalatli.techchallenge.data

import com.kemalatli.techchallenge.domain.OrdersRepository
import com.kemalatli.techchallenge.model.Order
import io.reactivex.Single
import retrofit2.Retrofit

class OrdersRepositoryImpl(private val retrofit: Retrofit):OrdersRepository {

    /**
     * Concrete service implementation for getting data from Kariyer endpoint.
     */
    private val orderService :OrderService by lazy { retrofit.create(OrderService::class.java)}

    /**
     * Fetch orders from [OrderService]
     */
    override fun getOrders(): Single<List<Order>> = orderService.getListOfOrders()

}