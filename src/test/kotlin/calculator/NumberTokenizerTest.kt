package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberTokenizerTest {

    private lateinit var numberTokenizer: NumberTokenizer

    @BeforeEach
    fun setUp() {
        numberTokenizer = NumberTokenizer()
    }

    @Test
    fun `문자열을 쉼표를 통해 나누기`() {
        val result = numberTokenizer.tokenize("1,3,-56.5,7", listOf(",", ":"))
        val expect = listOf("1", "3", "-56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론을 통해 나누기`() {
        val result = numberTokenizer.tokenize("1:3:56.5:7", listOf(",", ":"))
        val expect = listOf("1", "3", "56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론과 쉼표를 통해 나누기`() {
        val result =
            numberTokenizer.tokenize(
                "1,3:531236.512873921873298472394827928719242591283792187413984731984713:7,82:",
                listOf(",", ":")
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
        val result = numberTokenizer.tokenize("//;\\n1;23a43//3a4\\n//&&\\n&&44", listOf(":", ":", ";", "3a4", "&&"))
        val expect = listOf("1", "2", "3", "44").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `구분한 숫자가 음수일 경우 예외 처리 테스트`() {
        assertThrows<IllegalArgumentException> {
            numberTokenizer.tokenize("1,3,-3,5", listOf(",", ":"))
        }
    }

    @Test
    fun `커스텀 구분자 선언 외에 숫자가 아닌 문자가 있을 경우 예외 처리 테스트`() {
        assertThrows<IllegalArgumentException> {
            numberTokenizer.tokenize("//;\\n1;23,a43", listOf(",", ":", ";"))
        }
    }
}