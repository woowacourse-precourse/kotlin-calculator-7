package calculator

import calculator.model.InputParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @DisplayName("InputParser Test : 커스텀 구분자 정의 제거")
    @Test
    fun removeCustomDelimiterDefinitionWithCustom() {
        val input = "//$\\n1,2$3"
        val expected = "1,2$3"

        val result = InputParser(listOf(",", ":", "$")).removeDelimiterDefinition(input)

        assertEquals(expected, result)
    }

    @DisplayName("InputParser Test : 커스텀 구분자 정의 제거 (커스텀 구분자가 여러 개인 경우)")
    @Test
    fun removeCustomDelimiterDefinitionWithMultipleCustom() {
        val input = "//$\\n//^\\n1^2$3"
        val expected = "1^2$3"

        val result = InputParser(listOf(",", ":", "$", "^")).removeDelimiterDefinition(input)

        assertEquals(expected, result)
    }

    @DisplayName("InputParser Test : 커스텀 구분자 정의 제거 (없을 경우)")
    @Test
    fun removeCustomDelimiterDefinitionWithoutCustom() {
        val input = "1,2,3"
        val expected = "1,2,3"

        val result = InputParser(listOf(",", ":")).removeDelimiterDefinition(input)

        assertEquals(expected, result)
    }

    @DisplayName("InputParser Test : 입력받은 문자열에서 구분자를 사용해 숫자를 추출")
    @Test
    fun findAllNumbersTest() {
        val input = "1,2:3"
        val expected = listOf(1, 2, 3)

        val result = InputParser(delimiters = listOf(",", ":")).extractNumbers(input)
        assertEquals(expected, result)
    }

    @DisplayName("InputParser Test : 입력받은 문자열에서 구분자를 사용해 숫자를 추출 (숫자가 아닌 값이 있는 경우)")
    @Test
    fun findAllNumbersNonNumericExceptionTest() {
        val input = "1,a,3"

        val exception = assertThrows<IllegalArgumentException> { InputParser(listOf(",", ":")).extractNumbers(input) }

        assert(exception.message == InputParser.INVALID_NUMBER_MESSAGE)
    }

    @DisplayName("InputParser Test : 추출된 리스트에 음수 유무 (통과)")
    @Test
    fun isContainNegativeNumberSuccessTest() {
        val input = "1,2,3"

        val manager = InputParser(listOf(",", ":"))
        val nums = manager.extractNumbers(input)
        val result = manager.containNegativeNumber(nums)

        assertTrue(result)
    }

    @DisplayName("InputParser Test : 추출된 리스트에 음수 유무 (실패)")
    @Test
    fun isContainNegativeNumberFailureTest() {
        val input = "1,-1,3"

        val manager = InputParser(listOf(",", ":"))
        val nums = manager.extractNumbers(input)
        val exception = assertThrows<IllegalArgumentException> { manager.containNegativeNumber(nums) }

        assert(exception.message == InputParser.NEGATIVE_NUMBER_MESSAGE)
    }
}