package calculator

import calculator.model.InputManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputManagerTest {

    @DisplayName("InputManager Test : 커스텀 구분자 정의 제거")
    @Test
    fun removeCustomDelimiterDefinitionWithCustom() {
        val input = "//$\\n1,2$3"
        val expected = "1,2$3"

        val result = InputManager(listOf(",", ":", "$")).removeCustomDelimiterDefinition(input)

        assertEquals(expected, result)
    }

    @DisplayName("InputManager Test : 커스텀 구분자 정의 제거 (커스텀 구분자가 여러 개인 경우)")
    @Test
    fun removeCustomDelimiterDefinitionWithMultipleCustom() {
        val input = "//$\\n//^\\n1^2$3"
        val expected = "1^2$3"

        val result = InputManager(listOf(",", ":", "$", "^")).removeCustomDelimiterDefinition(input)

        assertEquals(expected, result)
    }

    @DisplayName("InputManager Test : 커스텀 구분자 정의 제거 (없을 경우)")
    @Test
    fun removeCustomDelimiterDefinitionWithoutCustom() {
        val input = "1,2,3"
        val expected = "1,2,3"

        val result = InputManager(listOf(",", ":")).removeCustomDelimiterDefinition(input)

        assertEquals(expected, result)
    }

    @DisplayName("InputManager Test : 입력받은 문자열에서 구분자를 사용해 숫자를 추출")
    @Test
    fun findAllNumbersTest() {
        val input = "1,2:3"
        val expected = listOf(1, 2, 3)

        val result = InputManager(delimiters = listOf(",", ":")).findAllNumbers(input)
        assertEquals(expected, result)
    }

    @DisplayName("InputManager Test : 입력받은 문자열에서 구분자를 사용해 숫자를 추출 (숫자가 아닌 값이 있는 경우)")
    @Test
    fun findAllNumbersNonNumericExceptionTest() {
        val input = "1,a,3"

        val exception = assertThrows<IllegalArgumentException> { InputManager(listOf(",", ":")).findAllNumbers(input) }

        assert(exception.message == InputManager.NON_NUMERIC_MESSAGE)
    }

    @DisplayName("InputManager Test : 추출된 리스트에 음수 유무 (통과)")
    @Test
    fun isContainNegativeNumberSuccessTest() {
        val input = "1,2,3"

        val manager = InputManager(listOf(",", ":"))
        val nums = manager.findAllNumbers(input)
        val result = manager.isContainNegativeNumber(nums)

        assertTrue(result)
    }

    @DisplayName("InputManager Test : 추출된 리스트에 음수 유무 (실패)")
    @Test
    fun isContainNegativeNumberFailureTest() {
        val input = "1,-1,3"

        val manager = InputManager(listOf(",", ":"))
        val nums = manager.findAllNumbers(input)
        val exception = assertThrows<IllegalArgumentException> { manager.isContainNegativeNumber(nums) }

        assert(exception.message == InputManager.NEGATIVE_NUMBER_MESSAGE)
    }
}