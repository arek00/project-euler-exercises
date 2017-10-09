package com.arek00.projecteuler.utils

import org.junit.Test
import org.scalatest.junit.JUnitSuite

class MathUtilsTest extends JUnitSuite {

  @Test
  def shouldGetMaxOfNumbers(): Unit = {
    //given
    val numbers: Array[Long] = Array(0, 2, 3, 4, 5)

    //when
    val max = MathUtils.maxOf(numbers: _*)

    //then
    assert(max == 5)
  }
}
