package shop_components

import MenuOptionable
import MenuSelector
import data_classes.Phone
import java.util.*

class Seller(private val phoneList: List<Phone>, private val priceMod: Float) : MenuOptionable {
    private val statistics = mutableMapOf<Int, Int>()
    override val isOptional: Boolean
        get() = false

    override fun menuOption(): String {
        return "Buy a phone."
    }

    override fun enterServiceMode() {
        while (true) {
            println("Select phone by typing its number in the list:")
            phoneList.forEachIndexed { index, phone ->
                println("${index + 1}. ${phone.name}, price: ${(phone.basePrice * priceMod).format(2)}")
            }
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

    private fun sellPhone(index: Int) {
        statistics[index] = (statistics[index] ?: 0) + 1
        val phone = phoneList[index]
        println("Selling phone ${phone.name} with price: ${(phone.basePrice * priceMod).format(2)}")
    }

    private fun showStatistics() {
        println("Seller statistics:")
        var total = 0f
        phoneList.forEachIndexed { index, phone ->
            val count = (statistics[index] ?: 0)
            val price = phone.basePrice * count * priceMod
            println("${phone.name} - count: $count, total price for model: ${price.format(2)} ")
            total += price
        }
        println("Total price for all models sold: ${total.format(2)}")
    }
}

fun Float.format(digits: Int) = "%.${digits}f".format(this)