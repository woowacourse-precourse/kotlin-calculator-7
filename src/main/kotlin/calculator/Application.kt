package calculator

fun main() {

}

class Calculator {

    fun findCustom(line: String): Char? {
        val regex = "^//.\\n".toRegex()
        if (regex.matches(line)){
            return line.elementAt(2)
        }
        return null
    }
}