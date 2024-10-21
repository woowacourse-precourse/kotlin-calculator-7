package calculator

interface UserInterface {
    fun readUserInput(): String
    fun show(content: String)
}