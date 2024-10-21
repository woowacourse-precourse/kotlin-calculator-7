package calculator

class Token(kind: String, value: String = "") {
    var kind = kind
    var value = value
}

class CharReader(code:String="", var idx:Int=0) {

    var codeArray = code.toCharArray()
    fun read():Char {
        if (idx == codeArray.size) {
            //EOF Token
            return '!'
        }
        return codeArray[idx]
    }

    fun advance() {
        if (idx == codeArray.size) {
            return
        }
        idx += 1
    }

    fun retreat() {
        idx +- 1
    }
}

class Tokenizer(code:String="") {
    var reader = CharReader(code)
    var customOperator:MutableList<Char> = mutableListOf()



    fun tokenize():Token {
        var char = reader.read()
        reader.advance()

        if (char in ":,!\n") {

            return Token("Operator", char.toString())

        } else if (char == '\"') {
            return Token("defineCode", char.toString())

        } else if (char == '/') {
            var nextChar = reader.read()
            if (nextChar == '/') {
                reader.advance()

                var nextChar = reader.read()

                while (true){
                    customOperator.add(nextChar)
                    reader.advance()
                    nextChar = reader.read()

                    if (nextChar == '\\') {
                        reader.advance()
                        nextChar = reader.read()
                        if (nextChar == 'n') {
                            reader.advance()
                            break
                        }
                    }
                }

            } else {
            }

        } else if (char in "0123456789") {
            var numbers: MutableList<Char> = mutableListOf()
            numbers.add(char)

            while (true) {
                var nextChar = reader.read()
                if (nextChar in "0123456789") {
                    reader.advance()
                    numbers.add(nextChar)
                    continue
                }

                var value = numbers.joinToString(separator = "")
                return Token("number", value)
            }

        } else {
            if (customOperator.size == 0) {
            }
            for ((iter, customChar) in customOperator.withIndex()) {
                if (char == customChar) {

                    if (iter != customOperator.size - 1) {
                        char = reader.read()
                        reader.advance()
                    }

                } else {
                }
            }

            var value = customOperator.joinToString(separator = "")
            return Token("customOperator", value)
        }

        return Token("")
    }

    fun getTokens():List<Token> {
        var tokens: MutableList<Token> = mutableListOf()

        while (reader.read() != '!') {
            tokens.add(this.tokenize())
        }
        return tokens
    }
}

class Parser(var tokens:List<Token>) {
    fun result():Int {
        var expression = ""
        for (token in tokens) {
            if (token.kind == "defineCode") {
                continue
            } else if (token.kind == "number") {
                expression += token.value
            } else if (token.kind == "Operator") {
                expression += "+"
            } else {
                continue
            }
        }
        val numbers = expression.split("+").map { it.toInt() }
        val result = numbers.sum()
        return result
    }

}

fun main() {
    // TODO: 프로그램 구현
    print("덧셈할 문자열을 입력해 주세요\n")
    val name = camp.nextstep.edu.missionutils.Console.readLine()
    val tokens = Tokenizer(name).getTokens()
    val result = Parser(tokens).result()
    print("결과 : " + result)

}
