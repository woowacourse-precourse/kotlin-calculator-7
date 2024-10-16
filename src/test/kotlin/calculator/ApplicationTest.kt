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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `앞 5문자 유효성 검증`() {
        assertSimpleTest {
            val inputStringArray =
                arrayOf(
                    inputString6,
                    inputString7,
                    inputString8,
                    inputString9,
                    inputString10,
                    inputString11,
                    inputString12,
                    inputString13,
                    inputString14,
                    inputString15,
                )
            inputStringArray.map {
                try {
                    println("Passed : $it - ${Validator().validateCustomDelimiter(it)}")
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("Failed : $it")
                }
            }
        }
    }

    @Test
    fun `문자열 유효성 검증`() {
        assertSimpleTest {
            inputStringArray.map {
                try {
                    Validator().validateString(it)
                    println("Passed : $it")
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("Failed : $it")
                }
            }
        }
    }

    @Test
    fun `문자열 분리 테스트`() {
        assertSimpleTest {
            val validInputStringArray =
                arrayOf(inputString4, inputString6, inputString7, inputString8)
            validInputStringArray.map {
                println("input = $it : ${Calculator().splitString(it)}")
            }
        }
    }

    companion object {
        val inputString1 = "0,2r3;4" // 비정상 - 유효하지 않은 문자 'r'
        val inputString2 = "0,2,3;4;" // 비정상 - 마지막 문자가 구분자
        val inputString3 = ";0,2,3,4" // 비정상 - 첫 문자가 구분자
        val inputString4 = "0,2:3:4" // 정상
        val inputString5 = "0,,2:3,4" // 비정상 - 구분자가 연속해서 나옴
        val inputString6 = "//;\\n0;22,33:4" // 정상
        val inputString7 = "//r\\n0,22r33:4" // 정상
        val inputString8 = "// \\n0 22,33:4" // 정상
        val inputString9 = "//;\\nn10:2,3" // 비정상 - 유효하지 않은 문자 'n'
        val inputString10 = "//0\\n10:2,3" // 비정상 - 커스텀 구분자가 숫자임
        val inputString11 = "/;\\n10:2,3" // 비정상 - 앞 두문자가 "//" 이 아님
        val inputString12 = "//;,\\n10:2,3" // 비정상 - 커스텀 구분자가 char 가 아님
        val inputString13 = "//p\\10p2,3" // 비정상 - 5번째 문자가 'n' 이 아님
        val inputString14 = "//p/n10p2,3" // 비정상 - 4번째 문자가 '\' 이 아님
        val inputString15 = "//\\n1,2,3" // 비정상 - 커스텀 구분자가 없음

        val inputStringArray =
            arrayListOf(
                inputString1,
                inputString2,
                inputString3,
                inputString4,
                inputString5,
                inputString6,
                inputString7,
                inputString8,
                inputString9,
                inputString10,
                inputString11,
                inputString12,
                inputString13,
                inputString14,
                inputString15,
            )
    }

    override fun runMain() {
        main()
    }
}
