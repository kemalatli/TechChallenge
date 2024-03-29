package com.kemalatli.techchallenge.features.order

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.kemalatli.techchallenge.ItemOrderBindingModel_
import com.kemalatli.techchallenge.R
import com.kemalatli.techchallenge.databinding.FragmentOrdersBinding
import com.kemalatli.techchallenge.features.login.LoginViewModel

class OrdersFragment: BaseMvRxFragment() {

    private var binding: FragmentOrdersBinding? = null
    private val loginViewModel:LoginViewModel by activityViewModel()
    private val viewModel:OrdersViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOrdersBinding.inflate(layoutInflater)
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set refresh listener so that we can reload items from viewmodel
        binding?.swipeRefresh?.setOnRefreshListener(viewModel::getOrders)
        // Set prompt for logout
        binding?.logout?.setOnClickListener {
            AlertDialog.Builder(context)
                .setMessage(R.string.orders_prompt_logout)
                .setNegativeButton(R.string.orders_prompt_logout_no,null)
                .setPositiveButton(R.string.orders_prompt_logout_yes) { d, v -> loginViewModel.logout() }
                .show()
        }
        binding?.executePendingBindings()
    }

    override fun invalidate():Unit = withState(viewModel){ state ->
        // Change bound data whenever viewmodel state changes
        binding?.state = state
        // Change recyclerview items whenever viewmodel state changes
        binding?.recyclerView?.withModels {
            state.orders.forEach { order ->
                ItemOrderBindingModel_()
                    .id(order.id)
                    .viewmodel(viewModel)
                    .isCollapsed(!state.expandedOrders.contains(order.id))
                    .order(order)
                    .addTo(this)
            }
        }
        binding?.executePendingBindings()
    }

}