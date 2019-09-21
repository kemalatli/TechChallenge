package com.kemalatli.techchallenge.base.viewmodel

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.BuildConfig
import com.airbnb.mvrx.MvRxState
import org.koin.core.KoinComponent

/**
 * Base abstract class implementation for holding state and configurations
 */
abstract class BaseViewModel<S: MvRxState>(initialState:S): BaseMvRxViewModel<S>(initialState,BuildConfig.DEBUG), KoinComponent