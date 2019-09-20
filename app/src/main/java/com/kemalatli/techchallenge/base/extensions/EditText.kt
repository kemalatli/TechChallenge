package com.kemalatli.techchallenge.base.extensions

import android.text.Editable
import android.text.Spanned
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

fun EditText.prefix(prefix:String){
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            var txt = "${p0 ?: ""}"
            if(!txt.startsWith(prefix)) txt = prefix + txt
            removeTextChangedListener(this)
            setText(txt)
            setSelection(txt.length)
            addTextChangedListener(this)
        }
    })
}

@BindingAdapter("textDistinct")
fun EditText.setTextIfDifferent(newText: CharSequence?): Boolean {
    if (!isTextDifferent(newText, text)) {
        return false
    }
    setText(newText)
    setSelection(newText?.length ?: 0)
    return true
}

fun isTextDifferent(str1: CharSequence?, str2: CharSequence?): Boolean {
    if (str1 === str2) {
        return false
    }
    if (str1 == null || str2 == null) {
        return true
    }
    val length = str1.length
    if (length != str2.length) {
        return true
    }

    if (str1 is Spanned) {
        return str1 != str2
    }

    for (i in 0 until length) {
        if (str1[i] != str2[i]) {
            return true
        }
    }
    return false
}