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
    fun `Long 범위 병합 테스트`() {
        assertSimpleTest {
            run("1,9223372036854775800,2")
            assertThat(output()).contains("결과 : 9223372036854775803")
        }
    }

    @Test
    fun `Long 범위 초과 병합 테스트`() {
        assertSimpleTest {
            run("1,9223372036854775808,2")
            assertThat(output()).contains("결과 : 9223372036854775811")
        }
    }

    @Test
    fun `마이너스 부호 커스텀 구분자 테스트`() {
        assertSimpleTest {
            assertSimpleTest {
                run("""//-\n1-2,3""")
                assertThat(output()).contains("결과 : 6")
            }
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `커스텀 구분자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("""//\1,2,3""") }
        }
    }

    @Test
    fun `음수 입력값 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("""1,-2,3""") }
        }
    }

    @Test
    fun `숫자가 아닌 입력값 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("""1,nn,3""") }
        }
    }

    @Test
    fun `공백 입력값 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("""1,,3""") }
        }
    }

    override fun runMain() {
        main()
    }
}
