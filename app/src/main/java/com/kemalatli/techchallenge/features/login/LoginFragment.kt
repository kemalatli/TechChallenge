package com.kemalatli.techchallenge.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.kemalatli.techchallenge.databinding.FragmentLoginBinding

class LoginFragment: BaseMvRxFragment() {

    private var binding:FragmentLoginBinding? = null
    private val viewModel:LoginViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set initial binding data
        binding?.viewmodel = viewModel
        binding?.executePendingBindings()
    }

    override fun invalidate():Unit = withState(viewModel){
        // Change bound data whenever viewmodel state changes
        binding?.state = it
        binding?.executePendingBindings()
    }

}