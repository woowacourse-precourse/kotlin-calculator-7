package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberTokenizerTest {

    private val numberTokenizer: NumberTokenizer = NumberTokenizer()
    private val delimiter: List<String> = listOf(",", ":")

    @Test
    fun `문자열을 쉼표를 통해 나누기`() {
        val result = numberTokenizer.tokenize("1,3,56.5,7", delimiter)
        val expect = listOf("1", "3", "56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론을 통해 나누기`() {
        val result = numberTokenizer.tokenize("1:3:56.5:7", delimiter)
        val expect = listOf("1", "3", "56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론과 쉼표를 통해 나누기`() {
        val result =
            numberTokenizer.tokenize(
                "1,3:531236.512873921873298472394827928719242591283792187413984731984713:7,82",
                delimiter
            )
        val expect = listOf(
            "1",
            "3",
            "531236.512873921873298472394827928719242591283792187413984731984713",
            "7",
            "82"
        ).map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열 커스텀 구분자 포함 나누기 테스트`() {
        val customDelimiter = listOf(",", ":", ";", "3a4", "&&")
        val result = numberTokenizer.tokenize("//;\\n1;23a43//3a4\\n//&&\\n&&44", customDelimiter)
        val expect = listOf("1", "2", "3", "44").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `구분한 숫자가 음수일 경우 예외 처리 테스트`() {
        assertThrows<IllegalArgumentException> {
            numberTokenizer.tokenize("1,3,-3,5", delimiter)
        }
    }

    @Test
    fun `커스텀 구분자 선언 외에 숫자가 아닌 문자가 있을 경우 예외 처리 테스트`() {
        val customDelimiter = listOf(",", ":", ";")
        assertThrows<IllegalArgumentException> {
            numberTokenizer.tokenize("//;\\n1;23,a43", customDelimiter)
        }
    }
}