package com.kemalatli.techchallenge.base.extensions

import android.os.Handler
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(isBusy:Boolean){
    Log.d("refreshing","$isBusy")
    Handler().post { this.isRefreshing = isBusy }
}