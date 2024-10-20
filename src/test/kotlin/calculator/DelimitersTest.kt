package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DelimitersTest {

    private lateinit var delimiter: Delimiter

    @BeforeEach
    fun setUp() {
        delimiter = Delimiter()
    }


    @Test
    fun `문자열에서 구분자 추출 테스트`() {
        val result = delimiter.getDelimiters("//;\\n1;2and3//and\\n//&&\\n")
        val expect = listOf(",", ":", ";", "and", "&&")
        assertEquals(expect, result)
    }
}