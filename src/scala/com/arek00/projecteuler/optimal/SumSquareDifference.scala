package com.arek00.projecteuler.optimal

/**
  * The sum of the squares of the first ten natural numbers is,
  * *
  * 1^2 + 2^2 + ... + 10^2 = 385
  * The square of the sum of the first ten natural numbers is,
  * *
  * (1 + 2 + ... + 10)^2 = 552 = 3025
  * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
  * *
  * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
  */
object SumSquareDifference {

  def main(args: Array[String]): Unit = {
    val difference = calculateDifference(100)
    println(difference)
  }

  def calculateDifference(to: Int): Long = {
    return calculateSquareOfSum(to) - calculateSumOfSquares(to)
  }

  private def calculateSumOfSquares(to: Int): Long = {
    return (2 * to + 1) * (to + 1) * to / 6
  }

  private def calculateSquareOfSum(to: Int): Long = {
    val sum = to * (to + 1) / 2

    return sum * sum
  }
}
