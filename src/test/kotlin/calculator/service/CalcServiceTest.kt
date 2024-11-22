package calculator.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalcServiceTest {
    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3:6", "3:3"],
        delimiter = ':'
    )
    fun `일반 입력 정상 검사 확인`(input: String, expected: Int) {
        assertThat(CalcService.getSum(input)).isEqualTo(expected)
    }

    @Test
    fun `빈 문자열 0 반환 확인`() {
        assertThat(CalcService.getSum("")).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["""//@\n1,2@3:6""", """//$\n2$4,2:8"""],
        delimiter = ':'
    )
    fun `커스텀 입력 정상 검사 확인`(input: String, expected: Int) {
        assertThat(CalcService.getSum(input)).isEqualTo(expected)
    }
}