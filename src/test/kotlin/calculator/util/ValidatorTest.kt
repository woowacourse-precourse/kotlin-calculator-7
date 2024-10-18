package calculator.util

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Nested
    @DisplayName("validNumber() 메서드")
    inner class ValidNumber {

        @Nested
        @DisplayName("커스텀 구분자를 포함하지 않는 입력")
        inner class OriginDelimiter {
            val delimiter = arrayOf(",", ":")

            @Nested
            @DisplayName("예외 발생 X")
            inner class Success {
                @Test
                fun `정상적인 입력`() {
                    // given
                    val input = "1,2:3"

                    // when & then
                    assertThatCode {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }.doesNotThrowAnyException()
                }

                @Test
                fun `아무런 입력도 안했을 경우`() {
                    // given
                    val input = ""

                    // when & then
                    assertThatNoException().isThrownBy {
                        Validator.validNumber(input, delimiter = delimiter)
                    }
                }
            }

            @Nested
            @DisplayName("예외 발생 O")
            inner class Fail {
                @Test
                fun `음수 포함 입력`() {
                    // given
                    val input = "-1,2:3"

                    // when & then
                    assertThatIllegalArgumentException().isThrownBy {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }
                }

                @Test
                fun `0을 명시적으로 입력`() {
                    // given
                    val input = "-1,2:0"

                    // when & then
                    assertThatIllegalArgumentException().isThrownBy {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }
                }

                @Test
                fun `문자가 포함된 입력`() {
                    // given
                    val input = "-1,2:0,<"

                    // when & then
                    assertThatIllegalArgumentException().isThrownBy {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }
                }
            }
        }

        @Nested
        @DisplayName("커스텀 구분자를 포함하는 입력")
        inner class CustomDelimiter {
            val delimiter = arrayOf(".", "!", ";", "a")

            @Nested
            @DisplayName("예외 발생 X")
            inner class Success {
                @Test
                fun `정상적인 입력`() {
                    // given
                    val input = "100000.2!3;42;101000000000000000000000.a!3"

                    // when & then
                    assertThatCode {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }.doesNotThrowAnyException()
                }

                @Test
                fun `커스텀 구분자를 제외하면 아무런 값이 없는 경우`() {
                    // given
                    val input = ".!a"

                    // when & then
                    assertThatCode {
                        Validator.validNumber(input, delimiter = delimiter)
                    }.doesNotThrowAnyException()
                }
            }

            @Nested
            @DisplayName("예외 발생 O")
            inner class Fail {
                @Test
                fun `음수 포함 입력`() {
                    // given
                    val input = "-100000.-2!3;42;-101000000000000000000000.a!3"

                    // when & then
                    assertThatIllegalArgumentException().isThrownBy {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }
                }

                @Test
                fun `0을 명시적으로 입력`() {
                    // given
                    val input = "0.2!3;42;101000000000000000000000.a!3"

                    // when & then
                    assertThatIllegalArgumentException().isThrownBy {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }
                }

                @Test
                fun `문자가 포함된 입력`() {
                    // given
                    val input = "f.10;1"

                    // when & then
                    assertThatIllegalArgumentException().isThrownBy {
                        Validator.validNumber(number = input, delimiter = delimiter)
                    }
                }
            }
        }
    }

}