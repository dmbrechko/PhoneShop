import data_classes.Phone
import shop_components.Repairer
import shop_components.Seller

fun main(args:Array<String>){
    val phoneList = listOf(
        Phone("Phone X",123f),
        Phone("Pixel",183f),
        Phone("Alcatel", 93f),
        Phone("Nokia", 132f),
        Phone("Macedonia", 183f),
        Phone("Zephyrus", 73f)
    )
    val firstShopServices = listOf(
        Seller(phoneList, 1.1f),
        Repairer()
    )
    val secondShopServices = listOf(Seller(phoneList, 1.2f))
    val mainPanelOptions = listOf(
        Shop(firstShopServices, "Casablanca"),
        Shop(secondShopServices, "Los-Angeles")
    )
    MainPanel(mainPanelOptions).mainMenuSelector()
}