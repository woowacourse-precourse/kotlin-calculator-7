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

            run("""//\\n1\2\3""")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1;2,3:4") }
        }
    }

    @Test
    fun `기본 커스텀 구분자 혼용`() {
        assertSimpleTest {
            run("//;\\n1;2,3:4")
            assertThat(output()).contains("결과 : 10")
        }

        assertSimpleTest {
            run("//_\\n1_2_3:4,50")
            assertThat(output()).contains("결과 : 60")
        }
    }

    @Test
    fun `공백 입력`() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }

        assertSimpleTest {
            run(" ")
            assertThat(output()).contains("결과 : 0")
        }
    }

    override fun runMain() {
        main()
    }
}
