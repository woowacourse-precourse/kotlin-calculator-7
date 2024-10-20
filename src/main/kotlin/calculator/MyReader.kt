package calculator

import camp.nextstep.edu.missionutils.Console

class MyReader {
    fun readLine(): String =
        runCatching {
            Console.readLine()
        }.getOrElse {
            throw IllegalArgumentException()
        }


    fun close() =
        runCatching {
            Console.close()
        }.onFailure {
            throw IllegalArgumentException()
        }
}