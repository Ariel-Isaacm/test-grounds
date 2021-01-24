package main.kotlin.warmup

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int): Int = x + y

fun main() {
    println(calculate(3, 5, ::sum))
    println(calculate(3, 5) { a, b -> a * b })
    val func = operation()
    val result = func(2)
    println("Result:$result")
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase4("hello"))
    println(upperCase5("hello"))

    val orders = Order(listOf(Item("Bread", 25.0F), Item("Milk", 30.0F), Item("Water", 12F)))
    println("Max price item name: ${orders.maxPricedItemName()}")
    println("Max price item value: ${orders.maxPricedItemValue()}")
    println("Items: ${orders.commaDelimitedValues}")

}

data class Item(val name: String, val price: Float)
data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Float = this.items.maxBy { it.price }?.price ?: 0F
fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO PRODUCT"
val Order.commaDelimitedValues: String
    get() = this.items.map { it.name }.joinToString()

fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x


val upperCase1: (String) -> String = { str: String -> str.toUpperCase() }

val upperCase2: (String) -> String = { str -> str.toUpperCase() }

val upperCase3 = { str: String -> str.toUpperCase() }

val upperCase4: (String) -> String = { it.toUpperCase() }

val upperCase5: (String) -> String = String::toUpperCase