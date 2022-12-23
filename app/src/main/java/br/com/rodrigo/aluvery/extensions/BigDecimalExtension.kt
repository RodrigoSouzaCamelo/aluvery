package br.com.rodrigo.aluvery.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.toEUACurrency(): String {
    return NumberFormat
        .getCurrencyInstance(Locale("en", "us"))
        .format(this)
}