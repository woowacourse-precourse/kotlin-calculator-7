package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `빈 문자열 입력 시 결과는 0이어야 한다`() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `숫자 하나 입력 시 해당 숫자를 반환해야 한다`() {
        assertSimpleTest {
            run("5")
            assertThat(output()).contains("결과 : 5")
        }
    }

    @Test
    fun `쉼표로 구분된 숫자의 합을 반환해야 한다`() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `콜론으로 구분된 숫자의 합을 반환해야 한다`() {
        assertSimpleTest {
            run("1:2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }


    @Test
    fun `음수가 포함된 경우 예외를 발생시켜야 한다`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1,-2,3")
            }
            assertThat(exception.message).isEqualTo("${Constant.NEGATIVE_NUMBER}-2")
        }
    }

    @Test
    fun `유효하지 않은 숫자가 포함된 경우 예외를 발생시켜야 한다`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("1,a,3")
            }
            assertThat(exception.message).isEqualTo("${Constant.INVALID_NUMBER}a")
        }
    }

    @Test
    fun `잘못된 커스텀 구분자 형식 입력 시 예외를 발생시켜야 한다`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("//;1;2;3")
            }
            assertThat(exception.message).isEqualTo("잘못된 입력입니다. 잘못된 커스텀 구분자 형식입니다.")
        }
    }

    override fun runMain() {
        main()
    }
}
