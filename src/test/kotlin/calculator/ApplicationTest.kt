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
    fun `기본 구분자 콤마 사용`() {
        assertSimpleTest {
            run("1,2")
            assertThat(output()).contains("결과 : 3")
        }
    }

    @Test
    fun `기본 구분자 콜론 사용`() {
        assertSimpleTest {
            run("2:3")
            assertThat(output()).contains("결과 : 5")
        }
    }

    override fun runMain() {
        main()
    }
}
