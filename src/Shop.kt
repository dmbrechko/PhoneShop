import data_classes.Phone

class Shop(services: List<MenuOptionable>, private val city: String): MenuSelector<MenuOptionable>(services), MenuOptionable {
    override fun greetings() {
        println("Welcome to the phone shop!")
    }

    override fun menuIntro() {
        println("Please select a service you want to proceed!")
    }

    override fun menuOption(): String {
        return "Phone shop in $city"
    }

    override fun enterServiceMode() {
        mainMenuSelector()
    }

    override val isOptional: Boolean
        get() = false
}