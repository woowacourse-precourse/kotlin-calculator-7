package calculator

import java.math.BigInteger

class Calculator {

    private val calculateMemory = mutableListOf<List<BigInteger>>()

    fun sum(numbers: List<BigInteger>): BigInteger {
        calculateMemory.add(numbers)
        return numbers.reduce { BigIn, bigInteger -> BigIn.plus(bigInteger) }
    }

}