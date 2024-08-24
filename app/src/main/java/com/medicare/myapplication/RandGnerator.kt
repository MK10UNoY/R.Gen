package com.medicare.myapplication

import kotlin.random.Random
import kotlin.random.nextInt

fun generateRandomNumberFrom(lowerLimit: Int, upperLimit: Int): Int {
    return Random.nextInt(lowerLimit,upperLimit+1)
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
