package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `일반 구분자 사용`() {
        val testInput = arrayOf("\n", "1", "1,2", "1:2", "1,2:3", "2147483647","2147483648", "2147483647,2147483647,12")
        val testOutput = arrayOf("결과 : 0", "결과 : 1", "결과 : 3", "결과 : 3", "결과 : 6", "결과 : 2147483647", "결과 : 2147483647", "결과 : 4294967306")
        assertSimpleTest {
            for(i in 0 until testInput.size) {
                run(testInput[i])
                assertThat(output().contains(testOutput[i]))
            }
        }
    }

    @Test
    fun `커스텀 구분자 사용`() {
        val testInput = arrayOf("//;\\n1", "//;\\n", "//;\\n1;2;3")
        val testOutput = arrayOf("결과 : 1", "결과 : 0", "결과 : 6")
        for (i in 0 until testInput.size) {
            assertSimpleTest {
                run(testInput[i])
                assertThat(output()).contains(testOutput[i])
            }
        }
    }

    @Test
    fun `예외 테스트`() {
        val exception = arrayOf("-1", "-", "a", "-1,2,3", "1,,2,3", ",1,2,3", "1:2;3", "//;\\n1.2:3,4", "//;", "//;\\")
        exception.forEach {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException(it) }
            }
        }
    }

    override fun runMain() {
        main()
    }
}
