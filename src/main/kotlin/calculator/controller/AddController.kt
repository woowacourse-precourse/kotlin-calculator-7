package calculator.controller

import calculator.model.Repository

class AddController(private val repo: Repository) {

    fun addNum() {
        val intList = splitInput()
        repo.sum = intList.sum()
    }

    private fun splitInput(): List<Int> {
        val input = repo.userInput

        val strList = if (repo.customDivider != null)  {
            input.split(",", ":", repo.customDivider!!).toMutableList()
        } else {
            input.split(",", ":").toMutableList()
        }

        strList.removeAll(listOf(""))

        return strList.map { it.toInt() }
    }
}