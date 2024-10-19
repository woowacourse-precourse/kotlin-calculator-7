package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `일반 구분자 사용`() {
        val testInput = arrayOf("1", "1,2", "1,2:3")
        val testOutput = arrayOf("결과 : 1", "결과 : 3", "결과 : 6")
        assertSimpleTest {
            for(i in 0 until testInput.size) {
                run(testInput[i])
                assertThat(output().contains(testOutput[i]))
            }
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
