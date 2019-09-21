package com.kemalatli.techchallenge.features.order

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.kemalatli.techchallenge.model.Order

data class OrdersState(

    val ordersRequest:Async<List<Order>> = Uninitialized,
    val expandedOrders:List<String> = arrayListOf()

):MvRxState{

    // Sort orders by descending date
    val orders:List<Order> get() = (ordersRequest.invoke() ?: arrayListOf()).sortedByDescending { it.month + it.date }
    // Send loading information whenever orders are being loaded
    val isLoading get() = ordersRequest is Loading

}