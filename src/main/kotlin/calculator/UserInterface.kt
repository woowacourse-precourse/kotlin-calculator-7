package calculator

interface UserInterface<T> {
    fun readUserInput(): T
    fun show(content: T)
}