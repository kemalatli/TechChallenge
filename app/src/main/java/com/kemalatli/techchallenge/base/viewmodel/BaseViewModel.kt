package com.kemalatli.techchallenge.base.viewmodel

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.BuildConfig
import com.airbnb.mvrx.MvRxState
import org.koin.core.KoinComponent

abstract class BaseViewModel<S: MvRxState>(initialState:S): BaseMvRxViewModel<S>(initialState,BuildConfig.DEBUG), KoinComponent {



}