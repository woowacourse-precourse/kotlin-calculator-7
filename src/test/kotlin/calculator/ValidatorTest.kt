package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest : NsTest() {
    private val validator = Validator()

    @Test
    fun `커스텀구분자 정의만 있는 인풋_에러발생`() {
        assertSimpleTest {
            val input = "//+\\n"
            val delimiterDefineEndIndex = input.indexOf("\\n") + 2
            assertThrows<IllegalArgumentException> {
                assertThat(validator.validateDelimiterFormat(delimiterDefineEndIndex, input))
            }
        }
    }

    @Test
    fun `빈문자열 인풋_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                assertThat(validator.validateCustomDelimiter(""))
            }
        }
    }

    @Test
    fun `커스텀구분자 2글자 이상 인풋_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                assertThat(validator.validateCustomDelimiter("//]]\n1]]2]]]3"))
            }
        }
    }

    @Test
    fun `문자열인풋_숫자 문자열인 경우_결과반환`() {
        assertSimpleTest {
            assertThat(validator.validateNumber("1")).isEqualTo(1)
        }
    }

    @Test
    fun `문자열인풋_숫자이외의 문자가 포함된 경우_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateNumber("1ok")
            }
        }
    }

    @Test
    fun `문자열인풋_숫자 음수인 경우_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateNumber("-1")
            }
        }
    }

    override fun runMain() {
        main()
    }
}
