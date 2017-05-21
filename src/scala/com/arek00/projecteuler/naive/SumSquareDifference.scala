package com.arek00.projecteuler.naive

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
    val difference = calculateDifference(1, 100)

    println(difference)
  }

  def calculateDifference(from: Int, to: Int): Long = {
    val squareOfSum = calculateSquareOfSum(from, to)
    val sumOfSquares = calculateSumOfSquares(from, to)

    return squareOfSum - sumOfSquares
  }

  private def calculateSquareOfSum(from: Int, to: Int): Long = {
    var sum: Int = 0

    for (iteration <- from to to by 1) {
      sum = sum + iteration
    }

    return sum * sum
  }

  private def calculateSumOfSquares(from: Int, to: Int): Long = {
    var sum: Int = 0

    for (iteration <- from to to by 1) {
      sum = sum + (iteration * iteration)
    }

    return sum
  }

}
