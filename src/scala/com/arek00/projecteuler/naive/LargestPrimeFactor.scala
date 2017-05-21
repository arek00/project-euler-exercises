package com.arek00.projecteuler.naive

import scala.collection.mutable.ArrayBuffer

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/
object LargestPrimeFactor {

  val primes: ArrayBuffer[Long] = ArrayBuffer(2)

  def main(args: Array[String]): Unit = {
    val factor1 = estimateBiggestFactor(600851475143L)

    println(factor1)
  }

  private def estimateBiggestFactor(number: Long): Long = {
    var tempNumber = number

    while (tempNumber > 1) {
      var iteration = 0

      while (tempNumber % getPrime(iteration) != 0) {
        iteration = iteration + 1
      }

      tempNumber = tempNumber / getPrime(iteration)
    }

    return getPrime(primes.size - 1)
  }

  private def getPrime(index: Int): Long = {
    while (index >= primes.size) {
      estimateNextPrime()
    }

    return primes(index)
  }

  /**
    * Find next prime number is necessary
    */
  private def estimateNextPrime(): Long = {
    val size = primes.size

    val startValue = primes(size - 1)

    var currentValue = startValue + 1
    while (!isPrime(currentValue)) {
      currentValue = currentValue + 1
    }
    primes += currentValue

    return currentValue
  }

  /**
    * Check if given number is prime or
    *
    * @param value
    * @return
    */
  private def isPrime(value: Long): Boolean = {
    val size = primes.size

    for (iteration <- 0 until size by 1) {
      if (value % primes(iteration) == 0) {
        return false
      }
    }
    return true
  }
}
