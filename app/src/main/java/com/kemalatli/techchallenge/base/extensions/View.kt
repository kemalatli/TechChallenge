package com.kemalatli.techchallenge.base.extensions

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.view.View
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.DrawableCompat.setTint
import androidx.databinding.BindingAdapter
import com.kemalatli.techchallenge.model.Order

@BindingAdapter("tintStatus")
fun View.tintStatus(order:Order){

    if(background==null) return
    val color = when(order.productState){
        "Hazırlanıyor" -> Color.parseColor("#ff6600")
        "Onay Bekliyor" -> Color.RED
        else -> Color.GREEN
    }
    if (SDK_INT < LOLLIPOP) {
        val wrapDrawable = DrawableCompat.wrap(this.background)
        setTint(wrapDrawable, color)
        this.background = DrawableCompat.unwrap(wrapDrawable)
    } else {
        this.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

}


@BindingAdapter("textColor")
fun TextView.textColor(order:Order){

    val color = when(order.productState){
        "Hazırlanıyor" -> Color.parseColor("#ff6600")
        "Onay Bekliyor" -> Color.RED
        else -> Color.GREEN
    }
    this.setTextColor(color)

}

@BindingAdapter("isGone")
fun View.isGone(isGone:Boolean){
    this.visibility = if(isGone) View.GONE else View.VISIBLE
}