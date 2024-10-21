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
    fun `커스텀 구분자 사용2`() {
        assertSimpleTest {
            run("//;\\n1,2:3;4")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `예외 테스트 음수포함`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
            assertThat(output().contains("양수로 구성된 문자열을 입력해 주세요."))
        }
    }

    @Test
    fun `예외 테스트 입력오류`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a1,2,3") }
            assertThat(output().contains("a는 구분자가 아닙니다."))
        }
    }

    @Test
    fun `예외 테스트 입력오류2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//;\\nb1,2:a3;4c") }
            assertThat(output().contains("bac는 구분자가 아닙니다."))
        }
    }

    override fun runMain() {
        main()
    }
}
