package com.kemalatli.techchallenge.domain

import com.kemalatli.techchallenge.model.Order
import io.reactivex.Single

interface OrdersRepository {

    fun getOrders():Single<List<Order>>

}