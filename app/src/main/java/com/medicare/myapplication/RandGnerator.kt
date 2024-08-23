package com.medicare.myapplication

fun generateRandomNumberFrom(lowerLimit: Int, upperLimit: Int): Int {
    return (lowerLimit until upperLimit).random()
}
fun generateRandomNumberFrom1to100(): Int {
    val minValue = 1
    val maxValue = 100
    return (minValue..maxValue).random()
}
fun generateRandomNumberFrom1to1000(): Int {
    val minValue = 1
    val maxValue = 1000
    return (minValue..maxValue).random()
}
