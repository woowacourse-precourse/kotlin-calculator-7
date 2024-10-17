package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `정상적인 입력`() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `빈 문자열 입력`() {
        assertSimpleTest {
            // 사용자 입력으로 빈 문자열은 그냥 엔터를 입력하는 것을 의미합니다.
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `잘못된 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,") }
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
    fun `입력 값이 음수인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    override fun runMain() {
        main()
    }
}
