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
    fun `중복 구분자 테스트`() {
        assertSimpleTest {
            run("///*---\\n32,1:2*9/56-7")
            assertThat(output()).contains("결과 : 107")
        }
    }

    @Test
    fun `구분자로 backslash 사용 테스트`() {
        assertSimpleTest {
            run("///\\*-\\n32,1:2*9/56-7\\30")
            assertThat(output()).contains("결과 : 137")
        }
    }

    @Test
    fun `구분자로 숫자 사용 테스트`() {
        assertSimpleTest {
            run("///\\*46-\\n32,1:2*9/565-7\\30")
            assertThat(output()).contains("결과 : 91")
        }
    }

    @Test
    fun `Long 범위를 넘어가는 수에 대한 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("9223372036854775808") }
        }
    }

    @Test
    fun `커스텀 구분자 입력 시에 줄바꿈이 누락된 경우에 대한 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("///\\*-32,1:2*9/56-7\\30") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("///\\*-32,1:2*9/56-7\\\\") }
        }
    }

    override fun runMain() {
        main()
    }
}
