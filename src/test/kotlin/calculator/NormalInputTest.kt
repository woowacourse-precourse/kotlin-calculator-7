package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NormalInputTest : NsTest() {
    @Test
    fun `평범한 값 입력`() {
        assertSimpleTest {
            run("100,200:300")
            assertThat(output()).contains("결과 : 600")
        }
    }

    @Test
    fun `커스텀 구분자를 사용한 값 입력`() {
        assertSimpleTest {
            run("//|\\n1,2,3:4,5|6\n")
            assertThat(output()).contains("결과 : 21")
        }
    }

    @Test
    fun `커스텀 기호 구분자를 사용한 값 입력`() {
        assertSimpleTest {
            run("//★\\n1,2:3,2★1\n")
            assertThat(output()).contains("결과 : 9")
        }
    }

    @Test
    fun `비어있는 값 입력`() {
        assertSimpleTest {
            run("\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `커스텀 구분자와 비어있는 값 입력`() {
        assertSimpleTest {
            run("//★\\n\n")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `실수 값 입력`() {
        assertSimpleTest {
            run("1.1,1.2")
            assertThat(output()).contains("결과 : 2.3")
        }
    }

    @Test
    fun `공백 구분자와 실수값과 정수값 혼합 입력`() {
        assertSimpleTest {
            run("// \\n1:2,3:4:5,6:7 8,9.1,10")
            assertThat(output()).contains("결과 : 55.1")
        }
    }

    @Test
    fun `슬래시를 커스텀 구분자로 입력`() {
        assertSimpleTest {
            run("///\\n1:2,3:4:5,6:7/8,9.1,10")
            assertThat(output()).contains("결과 : 55.1")
        }
    }

    @Test
    fun `숫자를 커스텀 구분자로 사용한 올바른 입력`() {
        assertSimpleTest {
            run("//5\\n1,2:354")
            assertThat(output()).contains("결과 : 10")
        }
    }

    override fun runMain() {
        main()
    }
}
