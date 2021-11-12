package com.gnova.hotels.ui

import java.text.DecimalFormat

//formats Doubles - used to format the price in this app
fun Double.toPriceAmount(): String {
    val dec = DecimalFormat("###,###,###.00")
    return dec.format(this)
}

fun String.noZeros(): String {
    return (if (!this.endsWith(".00"))  {
        this
    } else {
        this.substring(0, this.length - 3) }).toString()
}
