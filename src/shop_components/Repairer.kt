package shop_components

import MenuOptionable

class Repairer: MenuOptionable {
    override val isOptional: Boolean
        get() = true
    override fun menuOption(): String {
        return "Repair phone."
    }

    override fun enterServiceMode() {
        while (true) {
            println("Type \"repair\" to repair, \"exit\" to exit.")
            val command = readln()
            when (command) {
                "repair" -> println("Phone repaired")
                "exit" -> break
                else -> println("Unknown command")
            }
        }
    }


}