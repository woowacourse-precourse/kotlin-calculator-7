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
    fun `커스텀 구분자 사용 및 계산`() {
        assertSimpleTest {
            run("//*\\n1*4*7")
            assertThat(output()).contains("결과 : 12")
        }
    }

    @Test
    fun `기본 구분자 사용 및 계산`() {
        assertSimpleTest {
            run("1,4,5")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `음수 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `빈 문자열 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }

    @Test
    fun `잘못된 구분자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1;2;3") }
        }
    }

    override fun runMain() {
        main()
    }
}
