package ShopComponents

import data_classes.Phone
import java.util.*

class Seller(val phoneList: List<Phone>, val priceMod: Float) : ShopComponent {
    val statistics = mutableMapOf<Int, Int>()

    override fun menuOption(): String {
        return "Buy a phone."
    }

    override fun enterServiceMode() {
        while (true) {
            println("Select phone by typing its number in the list:")
            phoneList.forEachIndexed { index, phone -> println("${index + 1}. ${phone.name}") }
            println("To show statistics type \"stats\", \"exit\" to return to main shop menu.")
            val command = readln()
            when (command.lowercase(Locale.getDefault())) {
                "stats" -> showStatistics()
                "exit" -> break
                else -> {
                    try {
                        val index = command.toInt() - 1
                        if (index in phoneList.indices) {
                            sellPhone(index)
                        } else {
                            println("We have only ${phoneList.size} models.")
                        }
                    } catch (e: Exception) {
                        println("Unknown command")
                    }
                }
            }
        }

    }

    fun sellPhone(index: Int) {
        statistics[index] = (statistics[index] ?: 0) + 1
        println("Selling phone ${phoneList[index]}")
    }

    fun showStatistics() {
        println("Seller statistics:")
        var total = 0f
        phoneList.forEachIndexed { index, phone ->
            val count = (statistics[index] ?: 0)
            val price = phone.basePrice * count * priceMod
            println("${phone.name} - count: $count, total price for model: $price ")
            total += price
        }
        println("Total price for all models sold: $total")
    }
}