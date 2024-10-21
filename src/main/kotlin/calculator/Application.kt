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

    fun separate(line: String, custom: Char?) :List<Int>{
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
        return numbers
    }

    fun plus(numbers:List<Int>):Int{
        return numbers.sum()
    }
    fun input():String {
        println("덧셈할 문자열을 입력해 주세요.")
        return readln()
    }
    fun output(total:Int){
        println("결과 : $total")
    }
}