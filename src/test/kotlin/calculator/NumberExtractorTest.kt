package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberExtractorTest {
    private lateinit var numberExtractor: NumberExtractor

    @BeforeEach
    fun setup() {
        numberExtractor = NumberExtractor()
    }

    @Test
    fun `커스텀 구분자 추가 성공 - 예외가 발생하지 않음`() {
        val separator = ";"
        numberExtractor.addSeparator(separator)
    }

    @Test
    fun `커스텀 구분자 추가 실패 - 2글자 이상`() {
        assertThrows<IllegalArgumentException> {
            numberExtractor.addSeparator(";;")
        }
    }

    @Test
    fun `커스텀 구분자 추가 실패 - 0글자`() {
        assertThrows<IllegalArgumentException> {
            numberExtractor.addSeparator("")
        }
    }

    @Test
    fun `문자열에서 숫자 추출 성공 - 기본 구분자`() {
        val value = longArrayOf(1, 22, 333, 1111, 666666, 70)
        val input = "${value[0]},${value[1]},${value[2]}:${value[3]}:${value[4]}:${value[5]}"

        val result: LongArray = numberExtractor.extractNumbers(input)

        assertEquals(result.size, value.size)
        for (i in value.indices) {
            assertTrue(result.contains(value[i]), "문자열에 포함된 숫자가 배열에 없습니다.")
        }
    }

    @ValueSource(strings = ["", ",", ":", "::", ",,", ",:", ":,"])
    @ParameterizedTest
    fun `문자열에서 숫자 추출 성공 - 공백 결과`(input: String) {
        val result: LongArray = numberExtractor.extractNumbers(input)

        assertTrue(result.contentEquals(longArrayOf()))
    }

    @ValueSource(strings = ["1:", ":12", ":12::", "::2:"])
    @ParameterizedTest
    fun `문자열에서 숫자 추출 성공 - 빈칸 포함 문자열 1`(input: String) {
        val result: LongArray = numberExtractor.extractNumbers(input)

        assertEquals(result.size, 1)
    }

    @ValueSource(strings = ["1:2:", ":1,2", "1::2", "::1:2:"])
    @ParameterizedTest
    fun `문자열에서 숫자 추출 성공 - 빈칸 포함 문자열 2`(input: String) {
        val result: LongArray = numberExtractor.extractNumbers(input)

        assertEquals(result.size, 2)
    }

    @ValueSource(strings = [";", ";3", "1;2", "1:2;", ";1,23", ":21n23", "1,2:3;43"])
    @ParameterizedTest
    fun `문자열에서 숫자 추출 실패 - 잘못된 구분자 포함`(input: String) {
        assertThrows<IllegalArgumentException> {
            numberExtractor.extractNumbers(input)
        }
    }

    @Test
    fun `문자열에서 숫자 추출 실패 - 너무 큰 값`() {
        assertThrows<IllegalArgumentException> {
            numberExtractor.extractNumbers("1:2,${Long.MAX_VALUE}1:3")
        }
    }
}
