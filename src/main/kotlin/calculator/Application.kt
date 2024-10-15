package calculator

import camp.nextstep.edu.missionutils.Console
import java.math.BigInteger
import kotlin.jvm.Throws

enum class TypeState {
    INT, LONG, BIG_INTEGER;

    fun upgradeType(): TypeState {
        return when (this) {
            INT -> LONG
            LONG -> BIG_INTEGER
            BIG_INTEGER -> BIG_INTEGER
        }
    }
}

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val info = Console.readLine()
    val separatorList: MutableSet<Char> = mutableSetOf()

    separatorList.add(',')
    separatorList.add(':')
    val startPoint: Int

    try {
        startPoint = findSeparator(info, separatorList)
    } catch (e: IllegalArgumentException) {
        Console.close(); return
    }

    Console.close()
}

@Throws(IllegalArgumentException::class)
fun sum(total: String, sum: String, flag: TypeState): Pair<String, TypeState> {
    if (flag == TypeState.BIG_INTEGER) {
        val totalConvert = BigInteger(total)
        val operand = BigInteger(sum)
        val result = totalConvert + operand

        return Pair(result.toString(), TypeState.BIG_INTEGER)
    }

    var currentState = flag

    while (currentState != TypeState.BIG_INTEGER) {
        var maxStr = when (currentState) {
            TypeState.INT -> Int.MAX_VALUE.toString()
            TypeState.LONG -> Long.MAX_VALUE.toString()
            else -> ""
        }
        val maxLength = Integer.max(sum.length, maxStr.length)
        val compareSum = sum.padStart(maxLength, '0')
        maxStr = maxStr.padStart(maxLength, '0')

        /**
         * T.MAX_VALUE >= total + sum 인 경우 현재 타입으로 연산하고 그렇지 않을 경우 타입을 올려줘야 하지만 우변이 범위를 넘어가 정상적인 연산이 불가능할 수 있음
         * T.MAX_VALUE - sum >= total 의 식을 사용할 시 타입 내에서 안전하게 비교할 수 있음
         */
        if (maxStr >= compareSum) {
            when (currentState) {
                TypeState.INT -> {
                    val totalConvert: Int = total.toInt()
                    val sumConvert: Int = sum.toInt()

                    if (Int.MAX_VALUE - sumConvert >= totalConvert) {
                        break
                    }
                }
                TypeState.LONG -> {
                    val totalConvert: Long = total.toLong()
                    val sumConvert: Long = sum.toLong()

                    if (Long.MAX_VALUE - sumConvert >= totalConvert) {
                        break
                    }
                }
                else -> {}
            }
        }

        currentState = currentState.upgradeType()
    }

    val resultStr = when (currentState) {
        TypeState.INT -> {
            (total.toInt() + sum.toInt()).toString()
        }
        TypeState.LONG -> {
            (total.toLong() + sum.toLong()).toString()
        }
        TypeState.BIG_INTEGER -> {
            (BigInteger(total) + BigInteger(sum)).toString()
        }
    }

    return Pair(resultStr, currentState)
}

@Throws(IllegalArgumentException::class)
fun findSeparator(inputString: String, separatorSet: MutableSet<Char>): Int {
    if (inputString.length < 4) {
        return 0
    }

    val opener = "//"
    val closer = """\n"""
    val openerCheck = inputString.slice(0..1) == opener

    if (!openerCheck) {
        return 0
    }

    val separator = inputString[2]
    val closerCheck = inputString.slice(3..4) == closer

    if (!closerCheck) {
        throw IllegalArgumentException()
    }

    separatorSet.add(separator)

    return 5
}