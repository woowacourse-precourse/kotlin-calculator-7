package calculator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilsTest {

    @Test
    fun `String List를 Int Array로 변환 성공`() {
        val v1 = 123
        val v2 = 234
        val input = mutableListOf("$v1", "$v2")

        val result = convertStringListToIntArray(input)

        assertTrue(result.contains(v1))
        assertTrue(result.contains(v2))
    }

    @Test
    fun `String List를 Int Array로 변환 실패 - 너무 큰 값`() {
        val v1 = 123
        val v2 = Int.MAX_VALUE
        val input = mutableListOf("$v1", "${v2}1")

        assertThrows<IllegalArgumentException> {
            convertStringListToIntArray(input)
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
}