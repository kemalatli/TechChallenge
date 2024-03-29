package com.kemalatli.techchallenge.features.order

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.kemalatli.techchallenge.base.viewmodel.BaseViewModel
import com.kemalatli.techchallenge.domain.OrdersRepository
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class OrdersViewModel(state:OrdersState, private val ordersRepository: OrdersRepository): BaseViewModel<OrdersState>(state) {

    init {
        getOrders()
    }

    /**
     * Fetch orders from backend and set returned value to [OrdersState]
     */
    fun getOrders(){
        ordersRepository.getOrders().subscribeOn(Schedulers.io()).execute {
            copy(ordersRequest=it)
        }
    }

    /**
     * Toggle between expanded and collapsed states by changing [OrdersState.expandedOrders]
     */
    fun expandOrCollapseOrder(orderId:String) = setState {
        val list = arrayListOf<String>()
        list.addAll(expandedOrders)
        if(list.contains(orderId)){
            list.remove(orderId)
        }else{
            list.add(orderId)
        }
        copy(expandedOrders=list.distinct())
    }

    companion object:MvRxViewModelFactory<OrdersViewModel,OrdersState>{
        override fun create(viewModelContext: ViewModelContext, state: OrdersState): OrdersViewModel? {
            val ordersRepository:OrdersRepository by viewModelContext.activity.inject()
            return OrdersViewModel(state, ordersRepository)
        }
    }

}