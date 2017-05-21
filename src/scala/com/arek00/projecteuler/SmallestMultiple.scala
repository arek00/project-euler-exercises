package com.arek00.projecteuler

/**
  * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
  *
  * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  */
object SmallestMultiple {

  private val dividers = Array(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  def main(args: Array[String]): Unit = {
    val number = findDivisableNumber()

    print(number)
  }

  def findDivisableNumber(): Int = {
    var value = 20
    val step = 20

    while (true) {
      if (isDivisable(value)) {
        return value
      }
      value = value + step
    }

    throw new IllegalStateException("Illegal state")
  }

  def isDivisable(number: Int): Boolean = {
    val primesCount = dividers.length

    for (iteration <- (primesCount - 1) to 0 by -1) {
      if (number % dividers(iteration) > 0) {
        return false
      }
    }

    return true
  }
}