import java.util.*

abstract class  MenuSelector<T: MenuOptionable>(val options: List<T>) {
    abstract fun greetings()
    abstract fun menuIntro()
    open fun wrongIndex() {
        println("Select number from options or type \"exit\" to exit.")
    }
    fun unknownCommand() {
        println("Unknown command.")
    }
    fun mainMenuSelector() {
        greetings()
        var isFirstTime = true
        while (true) {
            menuIntro()
            println("Type \"exit\" to exit.")
            options.forEachIndexed { index, option ->
                if (isFirstTime || !option.isOptional) {
                    println("${index + 1}. ${option.menuOption()}")
                }
            }
            val command = readln()
            when (command.lowercase(Locale.getDefault())) {
                "exit" -> break
                else -> {
                    try {
                        val index = command.toInt() - 1
                        if (index in options.indices && (isFirstTime || !options[index].isOptional)) {
                            options[index].enterServiceMode()
                        } else {
                            wrongIndex()
                        }
                    } catch (e: Exception) {
                        unknownCommand()
                    }
                }
            }
            isFirstTime = false
        }
    }
}