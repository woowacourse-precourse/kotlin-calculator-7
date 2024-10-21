package calculator

fun main() {
    val calculator = Calculator()
    calculator.calculate()
}

class Calculator {
    fun calculate(){
        val line = input()
        output(plus(separate(line,findCustom(line))))
    }

    private fun findCustom(line: String): Char? {
        val regex = "^//.\\\\n".toRegex()
        if (regex.containsMatchIn(line)) {
            return line.elementAt(2)
        }
        return null
    }

    private fun separate(line: String, custom: Char?) :List<Int>{
        val numbers = mutableListOf<Int>()
        var number = 0
        if (custom == null) {
            for (each in line) {
                if (each == ':' || each == ',') {
                    numbers.add(number)
                    number = 0
                } else if (each in '0'..'9') {
                    number = number * 10 + each.digitToInt()
                } else {
                    throw IllegalArgumentException()
                }
            }
        } else {
            val noCustom = line.substring(5)
            for (each in noCustom) {
                if (each == custom) {
                    numbers.add(number)
                    number = 0
                } else if (each in '0'..'9') {
                    number = number * 10 + each.digitToInt()
                } else {
                    throw IllegalArgumentException()
                }
            }
        }
        numbers.add(number)
        return numbers
    }

    private fun plus(numbers:List<Int>):Int{
        return numbers.sum()
    }
    private fun input():String {
        println("덧셈할 문자열을 입력해 주세요.")
        return readln()
    }
    private fun output(total:Int){
        println("결과 : $total")
    }
}