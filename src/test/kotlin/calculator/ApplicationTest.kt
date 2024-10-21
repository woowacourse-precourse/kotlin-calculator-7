package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `널 입력값`() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

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
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `커스텀 구분자 사용 2`() {
        assertSimpleTest {
            run("//and\\n1,2and3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 공백`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }

    @Test
    fun `예외 테스트 구분자로 시작`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",1,2:3") }
        }
    }

    @Test
    fun `예외 테스트 잘못된 커스텀 구분자 지정`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//;n1,2;3") }
        }
    }

    @Test
    fun `예외 테스트 잘못된 커스텀 구분자 지정 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("/;\\n1,2;3") }
        }
    }

    override fun runMain() {
        main()
    }
}
