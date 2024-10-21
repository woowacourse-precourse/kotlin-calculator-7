package calculator

fun main() {
    val validator = Validator()
    val controller = Controller(validator)
    val view = View(controller)
    view.start()
}
