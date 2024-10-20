package calculator

/**
 * 큰 수에 대해서 크기 제한 없이 처리할 수 있는 자료구조로, 덧셈 연산을 지원합니다.
 */
class BigInt(number: String) {

    private val value: MutableList<Short> = mutableListOf()

    init {
        for (char in number) {
            // 입력값이 숫자가 아닐 경우, throw error
            if (!char.isDigit()) {
                throw IllegalArgumentException()
            }
            this.value.add(char.toString().toShort())
        }
    }


    companion object {
        /**
         * 두 BigInt 객체의 값을 더한 새로운 BigInt 객체를 반환합니다.
         *
         * @param x 첫 번째 BigInt 객체
         * @param y 두 번째 BigInt 객체
         * @return 두 값을 더한 결과를 담은 BigInt 객체
         */
        fun add(x: BigInt, y: BigInt): BigInt {
            val result = mutableListOf<Int>()

            var xIdx = x.value.size - 1
            var yIdx = y.value.size - 1
            var carry = 0

            while (xIdx >= 0 || yIdx >= 0 || carry != 0) {
                val digit1 = if (xIdx >= 0) x.value[xIdx] else 0
                val digit2 = if (yIdx >= 0) y.value[yIdx] else 0

                val sum = digit1 + digit2 + carry
                val digitSum = sum % 10
                carry = sum / 10

                result.addFirst(digitSum)
                xIdx--
                yIdx--
            }

            return BigInt(result.joinToString(""))
        }

    }

    override fun toString(): String {
        return value.joinToString("")
    }
}