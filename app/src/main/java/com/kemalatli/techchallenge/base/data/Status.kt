package com.kemalatli.techchallenge.base.data

sealed class Status<T>{
    class Success<T>(val item:T): Status<T>()
    class Failed<T>(val message:String): Status<T>()
}