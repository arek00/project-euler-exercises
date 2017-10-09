package com.arek00.projecteuler.utils


object MathUtils {
  def maxOf(values: Long*): Long = {
    var max: Long = Long.MinValue
    values.foreach(value => if (value > max) max = value)
    return max
  }
}
