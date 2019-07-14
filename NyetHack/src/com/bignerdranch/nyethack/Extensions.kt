package com.bignerdranch.nyethack

import com.sun.org.apache.xpath.internal.operations.Bool

val String.numVowels
    get() = count { "aeiou".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

infix fun String?.printWithDefault(default: String) = println(this ?: default)

/**
 * eXtension to Int that determines whether a number is prime
 */
fun Int.isPrime(): Boolean {


    return true
}

fun main(args: Array<String>) {
    "Madrigal has left the building".easyPrint().addEnthusiasm(2).easyPrint()
    24.easyPrint()
    "how many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default String"
}
