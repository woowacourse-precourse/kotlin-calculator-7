package calculator

fun main() {

}

class Calculator {

    fun findCustom(line: String): Char? {
        val regex = "^//.\\n".toRegex()
        if (regex.matches(line)) {
            return line.elementAt(2)
        }
        return null
    }

    fun separate(line: String, custom: Char?) {
        val numbers = mutableListOf<Int>()
        if (custom == null) {
            var number = 0
            for (each in line) {
                if (each == ':' || each == ',') {
                    numbers.add(number)
                    number = 0
                    continue
                } else if (each in '0'..'9') {
                    number = number * 10 + each.digitToInt()
                } else {
                    throw IllegalArgumentException()
                }
            }
        } else {
            val noCustom = line.substring(5)
            var number = 0
            for (each in noCustom) {
                if (each == ':' || each == ',' || each == custom) {
                    numbers.add(number)
                    number = 0
                    continue
                } else if (each in '0'..'9') {
                    number = number * 10 + each.digitToInt()
                } else {
                    throw IllegalArgumentException()
                }
            }
        }
    }
}