package calculator

fun main() {
    val repo = Repository()
    val input = InOutController(repo)
    val add = AddController(repo)

    input.userInputGuide()
    input.input()
    add.addNum()
    input.printResult()
}
