package calculator

object InputProcessor {
    fun getCustomDelimiterIfExist(line: String): Char? {
        val delimiterExist = line.length == 3
                && line.startsWith("//")
                && !line[2].isDigit()

        return if (delimiterExist) line[2]
                else null
    }
}