package calculator.domain

data class CustomDelimitersResult(
    val customDelimiters: CharArray,
    val customDelimitersEndIndex: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomDelimitersResult

        if (!customDelimiters.contentEquals(other.customDelimiters)) return false
        if (customDelimitersEndIndex != other.customDelimitersEndIndex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = customDelimiters.contentHashCode()
        result = 31 * result + customDelimitersEndIndex
        return result
    }
}
