package com.arek00.projecteuler

import scala.collection.mutable

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/
object LargestPalindromeProduct {

  private val startAt: Int = 999
  private val stopAt: Int = 100

  def main(args: Array[String]): Unit = {
    val biggestPalindrome = findPalindrome(startAt, startAt, stopAt, stopAt)

    println(biggestPalindrome)
  }

  private def findPalindrome(startWithLeft: Int, startWithRight: Int, stopWithLeft: Int = 0, stopWithRight: Int = 0): Int = {
    val productsQueue = new mutable.Queue[(Int, Int)]()
    productsQueue.enqueue((startWithLeft, startWithRight))

    while (true) {
      val tuple = productsQueue.dequeue()

      if (tuple._1 < stopWithLeft || tuple._1 < stopWithRight) {
        throw new IllegalStateException("Could not find palindrome")
      }

      val multiplication = tuple._1 * tuple._2

      if (isPalindrome(multiplication)) {
        return multiplication
      }
      else {
        if (tuple._1 != tuple._2) {
          addUniqueToQueue((tuple._1 - 1, tuple._2), productsQueue)
        }
        addUniqueToQueue((tuple._1, tuple._2 - 1), productsQueue)
      }
    }

    throw new IllegalStateException("Could not find palindrome")
  }

  private def isPalindrome(number: Int): Boolean = {
    val numberAsString = number.toString
    val textLength = numberAsString.length
    val steps = textLength / 2

    for (iteration <- 0 until steps by 1) {
      if (numberAsString.charAt(iteration) != numberAsString.charAt(textLength - iteration - 1)) {
        return false
      }
    }

    return true
  }

  private def areSamePair(pair1: (Int, Int), pair2: (Int, Int)): Boolean = {
    return pair1._1 == pair2._1 && pair1._2 == pair2._2
  }

  private def addUniqueToQueue(pair: (Int, Int), queue: mutable.Queue[(Int, Int)]): Unit = {
    val isUnique = queue.count(queueElement => areSamePair(queueElement, pair)) <= 0

    if (isUnique) {
      queue.enqueue(pair)
    }
  }
}
