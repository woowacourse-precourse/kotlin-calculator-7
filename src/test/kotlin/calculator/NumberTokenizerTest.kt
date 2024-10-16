package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NumberTokenizerTest {

    private lateinit var stringSplitter: NumberTokenizer

    @BeforeEach
    fun setUp() {
        stringSplitter = NumberTokenizer()
    }

    @Test
    fun `문자열을 쉼표를 통해 나누기`() {
        val result = stringSplitter.tokenize("1,3,-56.5,7")
        val expect = listOf("1", "3", "-56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론을 통해 나누기`() {
        val result = stringSplitter.tokenize("1:3:56.5:7")
        val expect = listOf("1", "3", "56.5", "7").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론과 쉼표를 통해 나누기`() {
        val result = stringSplitter.tokenize("1,3:-531236.512873921873298472394827928719242591283792187413984731984713:7,-82:")
        val expect = listOf("1", "3", "-531236.512873921873298472394827928719242591283792187413984731984713", "7", "-82").map { it.toBigDecimal() }
        assertEquals(expect, result)
    }
}