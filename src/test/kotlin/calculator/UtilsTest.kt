package calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilsTest {

    @Test
    fun `String List를 Int Array로 변환 성공`() {
        val v1: Long = 123
        val v2: Long = 234
        val input = mutableListOf("$v1", "$v2")

        val result = convertStringListToLongArray(input)

        assertTrue(result.contains(v1))
        assertTrue(result.contains(v2))
    }

    @Test
    fun `String List를 Int Array로 변환 실패 - 너무 큰 값`() {
        val v1: Long = 123
        val v2: Long = Long.MAX_VALUE
        val input = mutableListOf("$v1", "${v2}1")

        assertThrows<IllegalArgumentException> {
            convertStringListToLongArray(input)
        }
    }

    @Test
    fun `빈 요소 제거 성공`() {
        val v1 = "123"
        val v2 = "234"
        val input = mutableListOf(v1, "", v2)

        removeBlankStringList(input)

        assertTrue(input.contains(v1))
        assertTrue(input.contains(v2))
        assertFalse(input.contains(""))
    }

    @Test
    fun `배열의 값을 더하는데 성공`() {
        val input = longArrayOf(1, 2, 3)

        val result = longArraySum(input)

        assertEquals(result, 6)
    }

    @Test
    fun `배열의 값을 더하는데 실패 - 범위 초과`() {
        val input = longArrayOf(1, 2, 3, Long.MAX_VALUE)

        assertThrows<IllegalArgumentException> {
            longArraySum(input)
        }
    }
}