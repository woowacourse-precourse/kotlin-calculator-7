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
    fun `숫자만 입력`() {
        assertSimpleTest {
            run("1234")
            assertThat(output()).contains("결과 : 1234")
        }
    }

    @Test
    fun `입력 값 예외 테스트_숫자 없이 구분자만 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",,:") }
        }
    }

    @Test
    fun `입력 값 예외 테스트_공밴만 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("    ") }
        }
    }

    @Test
    fun `입력 값 예외 테스트_기본 구분자로 시작`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",2:3") }
        }
    }

    @Test
    fun `입력 값 예외 테스트_기본 구분자로 끝남`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("2:3,") }
        }
    }

    @Test
    fun `입력 값 예외 테스트_커스텀 구분자로 시작`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//#\n2#") }
        }
    }

    override fun runMain() {
        main()
    }
}
