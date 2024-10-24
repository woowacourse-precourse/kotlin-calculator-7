package calculator

interface View {
    fun readUserInput(): String
    fun show(content: String)
}