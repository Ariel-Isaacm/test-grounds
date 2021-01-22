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
}

fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x