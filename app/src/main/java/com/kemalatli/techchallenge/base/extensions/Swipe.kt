package com.kemalatli.techchallenge.base.extensions

import android.os.Handler
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * Extension function and binding adapter for setting refreshing state
 */
@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(isBusy:Boolean){
    Handler().post { this.isRefreshing = isBusy }
}