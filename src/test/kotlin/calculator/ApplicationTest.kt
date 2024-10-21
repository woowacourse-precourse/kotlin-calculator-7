package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `기본 구분자 사용`() {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1;2;3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `커스텀 구분자와 기본 구분자 동시 사용`() {
        assertSimpleTest {
            run("//!\\n1!2:3,4")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `특수 기호 사용`() {
        assertSimpleTest {
            run("//.\\n1.2.3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `빈 입력값 테스트`() {
        assertSimpleTest {
            run(" ")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `숫자가 음수인 경우 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `잘못된 형식의 숫자 입력 시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,a,3") }
        }
    }

    @Test
    fun `커스텀 구분자 여러 개 사용`() {
        assertSimpleTest {
            run("//!@#\\n1!2@3#4")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `실수 계산`() {
        assertSimpleTest {
            run("1.2,2.4")
            assertThat(output()).contains("결과 : 3.6")
        }
    }

    override fun runMain() {
        main()
    }
}
