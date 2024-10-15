package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StringSplitterTest {

    private lateinit var stringSplitter: StringSplitter

    @BeforeEach
    fun setUp() {
        stringSplitter = StringSplitter()
    }

    @Test
    fun `문자열을 쉼표를 통해 나누기`() {
        val result = stringSplitter.split("1,3,56,7")
        val expect = listOf("1", "3", "56", "7")
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론을 통해 나누기`() {
        val result = stringSplitter.split("1:3:56:7")
        val expect = listOf("1", "3", "56", "7")
        assertEquals(expect, result)
    }

    @Test
    fun `문자열을 콜론과 쉼표를 통해 나누기`() {
        val result = stringSplitter.split("1,3:56,82:7")
        val expect = listOf("1", "3", "56", "82", "7")
        assertEquals(expect, result)
    }
}