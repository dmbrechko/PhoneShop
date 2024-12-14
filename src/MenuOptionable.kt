interface MenuOptionable {
    fun menuOption(): String
    fun enterServiceMode()
    val isOptional: Boolean
}