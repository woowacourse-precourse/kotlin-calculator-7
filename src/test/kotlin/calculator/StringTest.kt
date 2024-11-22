package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.params.provider.ValueSources

class StringTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3"])
    fun `Split 테스트`(input: String) {
        assertThat(StringPractice().splitNumbers(input)).containsExactly(1, 3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["(1,2)"])
    fun `괄호 벗김 테스트`(input: String) {
        assertThat(StringPractice().substringWithoutParentheses(input)).isEqualTo("1,2")
    }

    @Test
    @DisplayName("charAt() 메소드 사용 시 범위를 벗어나면 StringIndexOutOfBoundsException 발생")
    fun `charAt() 메소드 사용 시 범위 초과 예외 발생 테스트`() {
        val str = "abc"
        assertThatThrownBy { str[3] }
            .isInstanceOf(StringIndexOutOfBoundsException::class.java)
            .hasMessageContaining("Index 3 out of bounds for length 3")
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "2, true",
        "3, true",
        "4, false",
        "5, false"
    )
    @DisplayName("1, 2, 3을 가진 set 테스트, 4, 5는 false를 반환하는지 체크")
    fun `set 테스트`(input: Int, expected: Boolean) {
        val set = setOf(1, 2, 3)
        assertThat(set.contains(input)).isEqualTo(expected)
    }
}