package calculator

private const val INPUT_PREFIX = "덧셈할 문자열을 입력해 주세요."

fun main() {
    val reader = MyReader()
    val writer = MyWriter()

    writer.println(INPUT_PREFIX)

    reader.close()
    writer.close()
}

