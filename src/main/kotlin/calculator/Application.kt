package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var numList : IntArray = input()


}

fun input(): IntArray {
    val inputString = readLine()
    val numList : IntArray = numberExtraction(inputString)
    return numList
}

fun numberExtraction(inputString: String?): IntArray {

}