package Model

class Delimiter {
    fun numberSplit(input: String): List<Int> {
        val numbers = input.split(",", ":").map { it.toInt() }
        return numbers
    }
}