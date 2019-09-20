package com.kemalatli.techchallenge.features.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.kemalatli.techchallenge.databinding.FragmentOrdersBinding
import com.kemalatli.techchallenge.features.login.LoginViewModel

class OrdersFragment: BaseMvRxFragment() {

    private var binding: FragmentOrdersBinding? = null
    private val loginViewModel:LoginViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOrdersBinding.inflate(layoutInflater)
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.loginViewModel = loginViewModel
        binding?.executePendingBindings()
    }

    override fun invalidate():Unit = withState(loginViewModel){


    }

}