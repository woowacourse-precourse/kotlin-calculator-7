package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NumberTokenizerTest {

    private lateinit var numberTokenizer: NumberTokenizer

    @BeforeEach
    fun setUp() {
        numberTokenizer = NumberTokenizer()
    }

    @Test
    fun `문자열을 쉼표를 통해 나누기`() {
        val result = numberTokenizer.tokenize("1,3,-56.5,7")
        val expect = listOf("1", "3", "-56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론을 통해 나누기`() {
        val result = numberTokenizer.tokenize("1:3:56.5:7")
        val expect = listOf("1", "3", "56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론과 쉼표를 통해 나누기`() {
        val result = numberTokenizer.tokenize("1,3:-531236.512873921873298472394827928719242591283792187413984731984713:7,-82:")
        val expect = listOf("1", "3", "-531236.512873921873298472394827928719242591283792187413984731984713", "7", "-82").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열에서 커스텀 구분자 추출 테스트`(){
        val result = numberTokenizer.extractCustomDelimiters("//;\\n1;2and3//and\\n//&&\\n")
        val expect = listOf(";","and","&&")
        assertEquals(expect, result)
    }

    @Test
    fun `문자열 커스텀 구분자 포함 나누기 테스트`(){
        val result = numberTokenizer.tokenize("//;\\n1;23a43//3a4\\n//&&\\n&&44")
        val expect = listOf("1","2","3","44").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }
}