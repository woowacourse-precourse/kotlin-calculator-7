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
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")

            run("1:2:3")
            assertThat(output()).contains("결과 : 6")

            run("1,2:3,4")
            assertThat(output()).contains("결과 : 10")

            run(":")
            assertThat(output()).contains("결과 : 0")

            run(",2")
            assertThat(output()).contains("결과 : 2")
        }
    }

    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")

            run("//;\\n1;2:3")
            assertThat(output()).contains("결과 : 6")

            run("//a\\n1a2a3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,a:3") }
            assertThrows<IllegalArgumentException> { runException("/;n1,2;3") }
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
            assertThrows<IllegalArgumentException> { runException("//;\\n-1;2,3") }
            assertThrows<IllegalArgumentException> { runException("12 34") }

            assertThrows<IllegalArgumentException> { runException("//1\\n1,2,3") }
            assertThrows<IllegalArgumentException> { runException("//^;]\\n1;2;3") }
        }
    }

    override fun runMain() {
        main()
    }
}
