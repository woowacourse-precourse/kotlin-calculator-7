package calculator


fun main() {
    val reads = InputConsole().read()
    val separator = Separator(reads)
    val separators: List<String> = separator.values

    val expression = if (separator.isCustomSeparator) reads.split("\\n")[1] else reads

    // 구분자에 맞춰서 변환    (이 부분이 구분자로 나뉘어져야 한다.)
    val temps = expression.split(*separators.toTypedArray())
    var result = Number(expression[0])
    for (i in 1..<expression.length step 2) {
        val operator: Operator = Operator.find(reads[i])
        val target = Number(reads[i + 1])
        result = operator.calculate(result, target)
    }

    print("결과 : ${result.value}")
}
