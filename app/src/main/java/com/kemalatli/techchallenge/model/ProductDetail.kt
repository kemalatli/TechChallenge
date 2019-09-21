package com.kemalatli.techchallenge.model

data class ProductDetail(
    val orderDetail:String = "",
    val summaryPrice:Double = 0.0
){

    val properPrice:String get() = "${summaryPrice.toInt()}TL"

}