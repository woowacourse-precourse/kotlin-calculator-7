package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `"1"을 입력 했을 경우 1을 반환`() {
        assertSimpleTest {
            assertThat(calculate("1")).isEqualTo(1)
        }
    }

    @Test
    fun `"2"를 입력 했을 경우 2를 반환`() {
        assertSimpleTest {
            assertThat(calculate("2")).isEqualTo(2)
        }
    }

    @Test
    fun `""를 입력 했을 경우 0을 반환`() {
        assertSimpleTest {
            assertThat(calculate("")).isEqualTo(0)
        }
    }

    @Test
    fun `"1,2"를 입력했을 경우 3을 반환`() {
        assertSimpleTest {
            assertThat(calculate("1,2")).isEqualTo(3)
        }
    }

    @Test
    fun `"1,2,3"를 입력했을 경우 6을 반환`() {
        assertSimpleTest {
            assertThat(calculate("1,2,3")).isEqualTo(6)
        }
    }

    @Test
    fun `"1,2,3colon4"를 입력했을 경우 10을 반환`() {
        assertSimpleTest {
            assertThat(calculate("1,2,3:4")).isEqualTo(10)
        }
    }

    @Test
    fun `"50colon60"를 입력했을 경우 110을 반환`() {
        assertSimpleTest {
            assertThat(calculate("50:60")).isEqualTo(110)
        }
    }

    @Test
    fun `커스텀 구분자 설정`() {
        assertSimpleTest {
            assertThat(calculate("//;\n1;2;3")).isEqualTo(6)
        }
    }

//    @Test
//    fun `커스텀 구분자 사용`() {
//        assertSimpleTest {
//            run("//;\\n1")
//            assertThat(output()).contains("결과 : 1")
//        }
//    }
//
//    @Test
//    fun `예외 테스트`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
//        }
//    }
//
    override fun runMain() {
        main()
    }
}
