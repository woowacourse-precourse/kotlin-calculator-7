package calculator.domain

import calculator.domain.PositiveNumbersParser.Companion.CUSTOM_DELIMITERS_END
import calculator.domain.PositiveNumbersParser.Companion.CUSTOM_DELIMITERS_START
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositiveNumbersParserTest {
    private lateinit var sut: PositiveNumbersParser

    @BeforeEach
    fun setUp() {
        sut = PositiveNumbersParser()
    }

    @Test
    fun `쉼표로만 구분된 양수를 입력한 경우 양수 리스트 반환`() {
        // act
        val result = sut.parse("1,2,3")

        // assert
        assertThat(result).isEqualTo(listOf(1.0, 2.0, 3.0))
    }

    @Test
    fun `콜론으로만 구분된 양수를 입력한 경우 양수 리스트 반환`() {
        // act
        val result = sut.parse("1:2:3")

        // assert
        assertThat(result).isEqualTo(listOf(1.0, 2.0, 3.0))
    }

    @Test
    fun `쉼표와 콜론으로 구분된 양수를 입력한 경우 양수 리스트 반환`() {
        // act
        val result = sut.parse("1:2,3")

        // assert
        assertThat(result).isEqualTo(listOf(1.0, 2.0, 3.0))
    }

    @Test
    fun `양수를 하나만 입력한 경우 양수 리스트 반환`() {
        // act
        val result = sut.parse("234")

        // assert
        assertThat(result).isEqualTo(listOf(234.0))
    }

    @Test
    fun `쉼표와 콜론으로 구분된 양수인 실수 입력시 양수 리스트 반환`() {
        // act
        val result = sut.parse("1.2,3.4:5.6")

        // assert
        assertThat(result).isEqualTo(listOf(1.2, 3.4, 5.6))
    }

    @Test
    fun `빈 문자열을 입력한 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("") }
    }

    @Test
    fun `등록되지 않은 구분자로 양수를 구분시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("1;2;3") }
    }

    @Test
    fun `음수가 존재할 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("1,2,-3") }
    }

    @Test
    fun `0이 존재할 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("1,0,3") }
    }

    @Test
    fun `숫자가 아닌 글자가 존재하는 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("1,2,3a") }
    }

    @Test
    fun `구분자와 숫자사이에 공백이 있는 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("1,2, 3") }
    }

    @Test
    fun `커스텀 구분자 추가시 커스텀 구분자로 구분된 양수 리스트 반환`() {
        // act
        val result = sut.parse("${CUSTOM_DELIMITERS_START}+${CUSTOM_DELIMITERS_END}1+2+3,4:5")

        // assert
        assertThat(result).isEqualTo(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
    }

    @Test
    fun `여러 커스텀 구분자 추가시 커스텀 구분자로 구분된 양수 리스트 반환`() {
        // act
        val result = sut.parse("${CUSTOM_DELIMITERS_START}+-*/${CUSTOM_DELIMITERS_END}1+2-3/4*5")

        // assert
        assertThat(result).isEqualTo(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
    }

    @Test
    fun `커스텀 구분자에 아무것도 추가하지 않을 경우 기본 구분자로 구분된 양수 리스트 반환`() {
        // act
        val result = sut.parse("${CUSTOM_DELIMITERS_START}${CUSTOM_DELIMITERS_END}1,2:3")

        // assert
        assertThat(result).isEqualTo(listOf(1.0, 2.0, 3.0))
    }

    @Test
    fun `커스텀 구분자의 시작 생략시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse(";${CUSTOM_DELIMITERS_END}1,2:3") }
    }

    @Test
    fun `커스텀 구분자의 마지막 생략시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { sut.parse("${CUSTOM_DELIMITERS_START};1,2:3") }
    }

    @Test
    fun `커스텀 구분자만 입력시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            sut.parse("${CUSTOM_DELIMITERS_START};${CUSTOM_DELIMITERS_END}")
        }
    }

    @Test
    fun `양수 부분도 커스텀 구분자 내부에 입력시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            sut.parse("${CUSTOM_DELIMITERS_START};1,2;3:4${CUSTOM_DELIMITERS_END}")
        }
    }

    @Test
    fun `커스텀 구분자에 양수 추가시 올바르게 처리될 수 있는 경우 양수 리스트 반환`() {
        // act
        val result = sut.parse("${CUSTOM_DELIMITERS_START}1${CUSTOM_DELIMITERS_END}2131415")

        // assert
        assertThat(result).isEqualTo(listOf(2.0, 3.0, 4.0, 5.0))
    }

    @Test
    fun `커스텀 구분자에 양수 추가시 올바르게 처리될 수 없는 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> {
            sut.parse("${CUSTOM_DELIMITERS_START}1${CUSTOM_DELIMITERS_END}121314")
        }
    }
}
