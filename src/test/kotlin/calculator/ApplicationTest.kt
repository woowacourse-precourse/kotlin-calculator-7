package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기본 구분자 예시1`() {
        assertSimpleTest {
            run("2,2,3:3:5")
            assertThat(output()).contains("결과 : 15")
        }
    }

    @Test
    fun `기본 구분자 예시2`() {
        assertSimpleTest {
            run("1,2:3;4//;\\n")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `기본 구분자 예시3`() {
        assertSimpleTest {
            run("1,2:3/4///\\n")
            assertThat(output()).contains("결과 : 10")
        }
    }

    @Test
    fun `기본 구분자 예시4`() {
        assertSimpleTest {
            run("10,10:10")
            assertThat(output()).contains("결과 : 30")
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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    override fun runMain() {
        main()
    }
}
