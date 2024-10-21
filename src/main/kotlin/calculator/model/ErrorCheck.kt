package calculator.model

class ErrorCheck {
    private val divider = Divider()

    fun dividerCheck(inputValue: String): Int { //어떤 구분자인지 체크, 어느 것도 아니라면 에러 발생
        when {
            divider.isDefault(inputValue) -> return 0
            divider.isCustom(inputValue) -> return 1
        }

        return -1
    }

    fun negativeNumberCheck(inputValueList: List<String>): Boolean {    //음수가 포함되어 있는지 확인
        if (!isNumberCheck(inputValueList)) {
            val newInputValueList = inputValueList.map { it.toInt() }
            for (i in newInputValueList.indices) {
                if (newInputValueList[i] <= 0) return true
            }
        }

        return false
    }

    fun isNumberCheck(inputValueList: List<String>): Boolean {  //숫자 이외의 값이 포함되어 있는지 확인
        try {
            inputValueList.map { it.toInt() }
        } catch (e: Exception) {
            return true
        }

        return false
    }
}
