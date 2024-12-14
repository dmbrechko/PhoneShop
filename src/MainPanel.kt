import data_classes.Phone

class MainPanel(shops: List<Shop>): MenuSelector<Shop>(shops) {
    override fun greetings() {
        println("Hello! Please select shop in your city.")
    }

    override fun menuIntro() {
        println("Shop available at this moment:")
    }
}