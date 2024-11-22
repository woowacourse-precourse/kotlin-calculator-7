package calculator.validator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputValidatorTest {
    @ParameterizedTest
    @CsvSource(
        value = ["a,b,c", "a,1,2", "1x2y3z", "z"]
    )
    fun `일반 문자열 유효성 검사 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { InputValidator.validateInput(input) }
    }

    @ParameterizedTest
    @CsvSource(
        value = ["//!!\n1"]
    )
    fun `커스텀 구분자 유효성 검사 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { InputValidator.validateInput(input) }
    }

    @ParameterizedTest
    @CsvSource(
        value = ["-1", "//$\n-3"]
    )
    fun `음수 존재 검사 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { InputValidator.validateInput(input) }
    }
}