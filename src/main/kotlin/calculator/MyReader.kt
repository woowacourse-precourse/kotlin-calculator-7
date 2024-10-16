package calculator

import java.io.BufferedReader
import java.io.InputStreamReader

class MyReader {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    fun readLine(): String {
        return runCatching {
            reader.readLine()
        }.getOrElse {
            throw IllegalArgumentException()
        }
    }

    fun close() {
        runCatching {
            reader.close()
        }.onFailure {
            throw IllegalArgumentException()
        }
    }
}