package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest : NsTest() {
    private val validator = Validator()

    @Test
    fun `문자열인풋_숫자 문자열인 경우_결과반환`() {
        assertSimpleTest {
            assertThat(validator.toIntOrThrow("1")).isEqualTo(1)
        }
    }

    @Test
    fun `문자열인풋_숫자이외의 문자가 포함된 경우_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.toIntOrThrow("1ok")
            }
        }
    }

    @Test
    fun `문자열인풋_숫자 음수인 경우_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.toIntOrThrow("-1")
            }
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본 구분자로 분리된 숫자들인 경우_결과반환`() {
        assertSimpleTest {
            assertThat(validator.splitAndSum("1:2", "[:]")).isEqualTo(3)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_커스텀 구분자로 분리된 숫자들인 경우_결과반환`() {
        assertSimpleTest {
            assertThat(validator.splitAndSum("1_2", "[_]")).isEqualTo(3)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본 구분자가 숫자와 숫자를 구분짓지 않은경우_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.splitAndSum(":1", "[:]")
            }
        }
    }

    @Test
    fun `숫자와 구분자 인풋_구분자길이가 2이상인 경우_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.splitAndSum("::1", "[:,]") //올바른 파라미터 처리인지?
            }
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본구분자와 양수숫자1개_결과반환`() {
        assertSimpleTest {
            assertThat(validator.validate("1")).isEqualTo(1)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본구분자와 양수숫자3개_결과반환`() {
        assertSimpleTest {
            assertThat(validator.validate("1,2:3")).isEqualTo(6)
        }
    }

    @Test
    fun `빈문자열 인풋_0반환`() {
        assertSimpleTest {
            assertThat(validator.validate("")).isEqualTo(0)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본구분자와 양수숫자1개_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validate(":1")
            }
        }
    }

    @Test
    fun `숫자와 구분자 인풋_커스텀구분자와 양수숫자1개_에러발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validate("//;\\n1")
            }
        }
    }

    override fun runMain() {
        main()
    }
}
