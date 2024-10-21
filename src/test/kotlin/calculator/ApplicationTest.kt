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
    fun `커스텀 구분자 없을 경우`() {
        assertSimpleTest {
            run("1,2,3,4,5")
            assertThat(output()).contains("결과 : 15")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 판별할 문자열 잘못 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("/>\\n1,2,3") }
        }
    }

    @Test
    fun `소수점 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1.1,2,3") }
        }
    }

    @Test
    fun `숫자가 아닌 문자 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,2,3") }
        }
    }

    override fun runMain() {
        main()
    }
}
