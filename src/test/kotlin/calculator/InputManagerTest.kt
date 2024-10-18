package calculator

import calculator.model.InputManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputManagerTest {

    @DisplayName("InputManager Test : 커스텀 구분자 정의 제거")
    @Test
    fun removeCustomDelimiterDefinitionWithCustom() {
        val input = "//$\\n1,2$3"
        val expected = "1,2$3"

        val result = InputManager(input, listOf(",", ":", "$")).removeCustomDelimiterDefinition()

        assertEquals(expected, result)
    }

    @DisplayName("InputManager Test : 커스텀 구분자 정의 제거 (커스텀 구분자가 여러 개인 경우)")
    @Test
    fun removeCustomDelimiterDefinitionWithMultipleCustom() {
        val input = "//$\\n//^\\n1^2$3"
        val expected = "1^2$3"

        val result = InputManager(input, listOf(",", ":", "$", "^")).removeCustomDelimiterDefinition()

        assertEquals(expected, result)
    }

    @DisplayName("InputManager Test : 커스텀 구분자 정의 제거 (없을 경우)")
    @Test
    fun removeCustomDelimiterDefinitionWithoutCustom() {
        val input = "1,2,3"
        val expected = "1,2,3"

        val result = InputManager(input, listOf(",", ":")).removeCustomDelimiterDefinition()

        assertEquals(expected, result)
    }
}