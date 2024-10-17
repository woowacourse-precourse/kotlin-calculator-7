package calculator

private const val INPUT_PREFIX = "덧셈할 문자열을 입력해 주세요."

fun main() {
    val reader = MyReader()
    val writer = MyWriter()
    val parser = MyParser()

    writer.println(INPUT_PREFIX)
    val input = reader.readLine()
    val result = parser.parse(input).sum()

    reader.close()
    writer.close()
}

