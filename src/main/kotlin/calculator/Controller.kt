package calculator

class Controller(private val view: View) {
    fun run(){
        try{

        } catch (e: IllegalArgumentException){
            view.showError(e)
        }
    }
}