package com.kemalatli.techchallenge.model

import java.text.SimpleDateFormat
import java.util.*

data class Order(

    val date:String = "",
    val month:String = "",
    val marketName:String = "",
    val orderName:String = "",
    val productPrice:Double = 0.0,
    val productState:String = "",
    var productDetail:ProductDetail? = ProductDetail()

){

    // Generated id to be used by DiffUtil
    val id:String get() = date + month + marketName + orderName + productPrice + productState
    // Calculated property for getting price in desired string format
    val properPrice:String get() = "${productPrice.toInt()}TL"
    // Calculated property for getting month value in text format in default locale
    val properMonth:String get() = SimpleDateFormat("MMMM", Locale.getDefault()).format(Date(2019,(month.toIntOrNull() ?: 1)-1, date.toIntOrNull() ?: 1))

}