package calculator.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigInteger

class ConverterTest {

    @Nested
    @DisplayName("extractNumberByInput() 메서드")
    inner class extractNumberByInput {
        @Test
        fun `커스텀 구분자를 포함하지 않은 입력을 List 형태로 정상 반환한다`() {
            // given
            val input = "1,3,2000:4:5"
            val expected =
                listOf(BigInteger("1"), BigInteger("3"), BigInteger("2000"), BigInteger("4"), BigInteger("5"))

            // when
            val actual = Converter.extractNumberByInput(input)

            // then
            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `커스텀 구분자 하나를 포함하는 입력을 List 형태로 정상 반환한다`() {
            // given
            val input = "//_\\n1_2_100000000000000000000000_4"
            val expected =
                listOf(BigInteger("1"), BigInteger("2"), BigInteger("100000000000000000000000"), BigInteger("4"))

            // when
            val actual = Converter.extractNumberByInput(input)

            // then
            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `커스텀 구분자 여러 개를 포함하는 입력을 List 형태로 정상 반환한다`() {
            // given
            val input = "//,;_.@#$\\n100,200$400#700;"
            val expected =
                listOf(BigInteger("100"), BigInteger("200"), BigInteger("400"), BigInteger("700"), BigInteger.ZERO)

            // when
            val actual = Converter.extractNumberByInput(input)

            // then
            assertThat(actual).isEqualTo(expected)
        }
    }
}