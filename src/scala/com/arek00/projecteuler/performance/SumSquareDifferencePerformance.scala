package com.arek00.projecteuler.performance

import com.arek00.projecteuler.naive.SumSquareDifference


object SumSquareDifferencePerformance {

  def main(args: Array[String]): Unit = {
    val naiveTime = runNaiveSolution()
    val optimalTime = runOptimalSolution()

    println("Naive time in millis: " + naiveTime / 1000000d)
    println("Optimal time in millis: " + optimalTime / 1000000d)
    println("Difference: " + (naiveTime - optimalTime) / 1000000d)
  }

  def runNaiveSolution(): Long = {
    val startTime = System.nanoTime()
    SumSquareDifference.calculateDifference(1, 100)
    val stopTime = System.nanoTime()

    return stopTime - startTime
  }


  def runOptimalSolution(): Long = {
    val startTime = System.nanoTime()
    com.arek00.projecteuler.optimal.SumSquareDifference.calculateDifference(100)
    val stopTime = System.nanoTime()

    return stopTime - startTime
  }

}
