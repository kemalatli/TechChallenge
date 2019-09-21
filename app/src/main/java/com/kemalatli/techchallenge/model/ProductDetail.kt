package com.kemalatli.techchallenge.model

data class ProductDetail(
    val orderDetail:String = "",
    val summaryPrice:Double = 0.0
){
    // Calculated property for getting price in desired string format
    val properPrice:String get() = "${summaryPrice.toInt()}TL"

}