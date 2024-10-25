package calculator.view

interface View {
    fun read(): String
    fun show(content: String)
    fun sum()
}