package com.bignerdranch

import com.bignerdranch.nyethack.easyPrint
import com.bignerdranch.nyethack.isPrime


fun main(args: Array<String>) {
    listOfFistThousandPrimeNumbers().toList().easyPrint()
}

// Challenge: Reversing the values in a map
fun <K, V> flipValues(map: Map<K, V>): Map<V, K> {
    return mapOf<V, K>()
}
fun reverseMapTest() {
    val gradesByStudent = mapOf("Luis" to 4.0, "Alberto" to 2.0, "Jesus" to 3.0)
    // {Luis=4.0, Alberto=2.0, Jesus=3.0}

    flipValues(gradesByStudent)
    // {4.0=Luis, 2.0=Alberto, 3.0=Jesus}
}

// example of a function using a sequence
fun listOfFistThousandPrimeNumbers(): Sequence<Int> {
    // using a list instead of a sequence, but 5000 initial numbers are not enough
    val toList = (1..5000).toList().filter { it.isPrime() }.take(1000)
    val oneThousandPrimes = generateSequence(1) {
        it + 1
    }.filter {
        it.isPrime()
    }.take(1000)
    return oneThousandPrimes
}

// example of Combine category of functions
fun accumulateNumbersMultipliedByThree() {
    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulator $accumulator")
        accumulator + number * 3
    }
}

// example of Combine category of functions
fun combineTwoCollectionsFunctionalStyle() {
    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes["Denny"])
}

// example of Filter category of functions
fun filterNonPrimeNumbers() {
    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }
                .none { it == 0 }
    }
    println(primes)
    // [7, 3, 11]
}

// example of Filter and Transform categories of functions
fun filteringAndFlattening() {
    val itemsOfManyColors = listOf(listOf("red apple", "green apple", "blue apple"),
            listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana"))

    val redItems = itemsOfManyColors.flatMap { it.filter { it.contains("red") } }
    println(redItems)
    // [red apple, red fish]
}


// example of Transforms category of functions
fun flatteringTwoLists() {
    listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap { it }
    // [1, 2, 3, 4, 5, 6]
}

// example of Transforms category of functions
fun sameNumberOfItemsDifferentTypes() {
    val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
    val tenDollarWordLenghts = tenDollarWords.map { it.length }
    println(tenDollarWordLenghts)
    // [10, 9, 7]
    println(tenDollarWords.size)
    // 3
    println(tenDollarWordLenghts.size)
    // 3
}

// example of Transforms category of functions
fun aTailOfBabiesAnimals() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
            .map{ animal -> "A baby $animal" }
            .map{ baby -> "$baby, with the cutest little tail ever!"}
    println(babies)
    println(animals)
}