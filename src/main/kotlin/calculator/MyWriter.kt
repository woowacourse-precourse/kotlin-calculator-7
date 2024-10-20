package calculator

import java.io.BufferedWriter
import java.io.OutputStreamWriter

class MyWriter {
    private val writer = BufferedWriter(OutputStreamWriter(System.out))
    fun print(a: Any?) =
        runCatching {
            writer.write(a.toString())
            writer.flush()
        }.onFailure {
            throw IllegalArgumentException()
        }

    fun printf(format: String, vararg args: Any?) =
        print(String.format(format, *args))

    fun println(a: Any?) =
        runCatching {
            print(a)
            writer.newLine()
            writer.flush()
        }.onFailure {
            throw IllegalArgumentException()
        }

    fun close() =
        runCatching {
            writer.close()
        }.onFailure {
            throw IllegalArgumentException()
        }
}