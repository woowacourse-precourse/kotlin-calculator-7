package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Nested
    inner class 테스트 {

        @Test
        fun 커스텀_구분자_여러_개_사용하는_경우() {
            assertSimpleTest {
                run("//;\\n//%\\n1;2%3")
                assertThat(output()).contains("결과 : 6")
            }
        }

        @Test
        fun 커스텀_구분자_정의_후_사용_안하는_경우() {
            assertSimpleTest {
                run("//;\\n1")
                assertThat(output()).contains("결과 : 1")
            }
        }

        @Test
        fun 빈_문자열인_경우() {
            assertSimpleTest {
                run("\n")
                assertThat(output()).contains("결과 : 0")
            }
        }

        @Test
        fun 커스텀_구분자_정의_후_빈_문자열인_경우() {
            assertSimpleTest {
                run("//;\\n")
                assertThat(output()).contains("결과 : 0")
            }
        }

        @Test
        fun 커스텀_구분자가_공백인_경우() {
            assertSimpleTest {
                run("// \\n1 2 3")
                assertThat(output()).contains("결과 : 6")
            }
        }
    }


    @Nested
    inner class 예외_테스트 {

        @Test
        fun 음수가_포함된_경우() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("-1,2,3") }
            }
        }

        @Test
        fun 숫자가_아닌_값이_포함된_경우() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("a,2,3") }
            }
        }

        @Test
        fun 커스텀_구분자_길이가_2_이상인_경우() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("//;;\\n") }
            }
        }

        @Test
        fun 커스텀_구분자가_숫자인_경우() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("//1\\n") }
            }
        }

        @Test
        fun 커스텀_구분자가_빈_문자인_경우() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("//\\n1,2") }
            }
        }
    }

    override fun runMain() {
        main()
    }
}
