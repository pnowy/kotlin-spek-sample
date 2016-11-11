package com.github.pnowy.spek

class AdvancedCalculator: Calculator() {
    fun pow(base: Int, exponent: Int) = Math.pow(base.toDouble(), exponent.toDouble()).toInt()
}