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
    fun `커스텀 구분자 문자열 테스트`() {
        assertSimpleTest {
            run("//;\\n1;2;3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `커스텀 구분자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//;1;2;3") }
        }
    }

    @Test
    fun `커스텀 구분자 예외 테스트2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(";\\n1;2;3") }
        }
    }

    @Test
    fun `커스텀 구분자 끝 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1;2;3//;\\n") }
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `정상 테스트`() {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `두 자리 양수 테스트`() {
        assertSimpleTest {
            run("12,45:45")
        }
    }

    @Test
    fun `음수 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,-2,3") }
        }
    }

    @Test
    fun `세 자리 양수 테스트`() {
        assertSimpleTest {
            run("123,456:789")
        }
    }

    @Test
    fun `두 자리 양수 커스텀 구분자 테스트`() {
        assertSimpleTest {
            run("//as\\n12a45s45")
        }
    }

    @Test
    fun `구분자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1 2 3") }
        }
    }

    @Test
    fun `시작 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" 1,2,3") }
        }
    }

    @Test
    fun `끝 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3 ") }
        }
    }

    @Test
    fun `구분자 시작 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",1,2,3") }
        }
    }

    @Test
    fun `구분자 끝 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,") }
        }
    }

    override fun runMain() {
        main()
    }
}
