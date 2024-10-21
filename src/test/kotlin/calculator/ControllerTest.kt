package calculator

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ControllerTest : NsTest() {
    private val validator = Validator()
    private val controller = Controller(validator)

    @Test
    fun `숫자와 구분자 인풋_기본구분자와 양수숫자1개_결과반환`() {
        Assertions.assertSimpleTest {
            assertThat(controller.calculate("1")).isEqualTo(1)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본구분자와 양수숫자3개_결과반환`() {
        Assertions.assertSimpleTest {
            assertThat(controller.calculate("1,2:3")).isEqualTo(6)
        }
    }

    @Test
    fun `빈문자열 인풋_0반환`() {
        Assertions.assertSimpleTest {
            assertThat(controller.calculate("")).isEqualTo(0)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본구분자 뒤 양수숫자1개_에러발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                controller.calculate(":1")
            }
        }
    }

    @Test
    fun `숫자와 구분자 인풋_커스텀구분자 뒤 양수숫자1개_에러발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                controller.calculate("//;\\n")
            }
        }
    }

    @Test
    fun `숫자와 커스텀구분자 인풋_숫자와 구분자 반환`() {
        Assertions.assertSimpleTest {
            val input = "//#\\n1#2#3"
            val result = controller.parseCustomDelimiterInput(input)
            assertThat(result).isEqualTo(Pair<String, String>("1#2#3", "#"))
        }
    }

    @Test
    fun `커스텀구분자 정의가 잘못된 인풋_커스텀구분자 반환`() {
        Assertions.assertSimpleTest {
            val input = "??#\\n1#2:3"
            assertThrows<IllegalArgumentException> {
                controller.parseInput(input)
            }
        }
    }

    @Test
    fun `커스텀구분자 포함 인풋_커스텀구분자 1글자_커스텀구분자 반환`() {
        Assertions.assertSimpleTest {
            val input = "//#\\n1#2:3"
            val idx = input.indexOf("\\n")
            assertThat(controller.extractCustomDelimiter(input, idx)).isEqualTo("#")
        }
    }

    @Test
    fun `커스텀구분자 포함 인풋_커스텀구분자 2글자_커스텀구분자 에러발생`() {
        Assertions.assertSimpleTest {
            val input = "//##\\n1##2:3"
            val idx = input.indexOf("\\n")
            assertThrows<IllegalArgumentException> {
                controller.extractCustomDelimiter(input, idx)
            }
        }
    }

    @Test
    fun `커스텀구분자 포함 인풋_숫자부분 반환`() {
        Assertions.assertSimpleTest {
            val input = "//#\\n1#2:3"
            val idx = input.indexOf("\\n") + 2
            assertThat(controller.extractNumberPart(input, idx)).isEqualTo("1#2:3")
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본 구분자로 분리된 숫자들인 경우_결과반환`() {
        Assertions.assertSimpleTest {
            assertThat(controller.splitAndSum("1:2", "[:]")).isEqualTo(3)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_커스텀 구분자로 분리된 숫자들인 경우_결과반환`() {
        Assertions.assertSimpleTest {
            assertThat(controller.splitAndSum("1_2", "[_]")).isEqualTo(3)
        }
    }

    @Test
    fun `숫자와 구분자 인풋_기본 구분자가 숫자와 숫자를 구분짓지 않은경우_에러발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                controller.splitAndSum(":1", "[:]")
            }
        }
    }

    @Test
    fun `숫자와 구분자 인풋_구분자길이가 2이상인 경우_에러발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                controller.splitAndSum("::1", "[:,]") //올바른 파라미터 처리인지?
            }
        }
    }

    override fun runMain() {
        main()
    }
}