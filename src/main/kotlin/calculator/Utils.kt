package calculator

fun convertStringListToLongArray(stringList: List<String>): LongArray {
    val result = LongArray(stringList.size)

    for (i in result.indices) {
        try {
            result[i] = stringList[i].toLong()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("너무 큰 값이 입력되었습니다.")
        }
    }

    return result
}

fun removeBlankStringList(list: MutableList<String>) {
    while (list.contains("")) {
        val i = list.indexOf("")
        list.removeAt(i)
    }
}
