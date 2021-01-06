package main.kotlin.warmup

fun main() {
    var a: String = "sup"
    println(a)
    val b: Int = 5
    val c = 3
    val contact = Contact(1, "something@company.com")
    println(contact.email)
    contact.email = "new@email.com"
    println(contact.email)

    val customer = Customer()
    println(customer)


    val myStack = mutableStackOf(1, 20, 30, 50)
    println(myStack)
    println(myStack.pop())
    println(myStack)

    val myDog: Dog = Pomerian()
    myDog.sayHi()
}

class Customer

class Contact(val id: Int, var email: String)

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()

    fun push(element: E) {
        elements.add(element)
    }

    fun peek(): E {
        return elements.last()
    }

    fun pop(): E {
        return elements.removeAt(elements.size - 1);
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty();
    }

    fun size(): Int {
        return elements.size
    }

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

open class Dog(){
    open fun sayHi(){
        println("woof woof")
    }
}

class Pomerian: Dog(){
    override fun sayHi() {
        println("le woof")
    }
}