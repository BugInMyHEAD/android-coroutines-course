package com.techyourchance.coroutines.exercises.exercise4

import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.math.BigInteger

class FactorialUseCaseTest {

    private lateinit var SUT: FactorialUseCase

    @Before
    fun setup() {
        SUT = FactorialUseCase()
    }

    @Test
    fun computeFactorial_0_returns1() {
        validateFactorial(0, "1")
    }

    @Test
    fun computeFactorial_1_returns1() {
        validateFactorial(1, "1")
    }

    @Test
    fun computeFactorial_10_returnsCorrectAnswer() {
        validateFactorial(10, "3628800")
    }

    @Test
    fun computeFactorial_30_returnsCorrectAnswer() {
        validateFactorial(30, "265252859812191058636308480000000")
    }

    private fun validateFactorial(argument: Int, bigIntegerString: String) {
        runBlocking {
            // Arrange
            // Act
            val result = SUT.computeFactorial(argument, 1000)
            // Assert
            assertThat((result as FactorialUseCase.Result.Success).result, `is`(BigInteger(bigIntegerString)))
        }
    }

}