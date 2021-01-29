package main.kotlin.warmup

import kotlin.reflect.KProperty

interface SoundBehavior {
    fun makeSound()
}

class ScreamBehavior(val n: String) : SoundBehavior {
    override fun makeSound() {
        println("${n.toUpperCase()}!!")
    }
}

class RockAndRollBehavior(val n: String) : SoundBehavior {
    override fun makeSound() {
        println("I'm the king of rock and roll: $n")
    }
}

class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n) {}

class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n) {}

fun main() {
    val tomAraya = TomAraya("Thrash metal")
    tomAraya.makeSound()
    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()

    val e = Example()
    println(e.p)
    e.p = "NEW"

    val lazy  = LazyExample()
    println("lazyStr = ${lazy.lazyStr}")
    println("= ${lazy.lazyStr}")


    val user = User2(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))
    println("name = ${user.name}, age = ${user.age}")
}


class Example {
    var p: String by Delegate()

    override fun toString(): String = "Example Class"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating ${prop.name} to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

class LazyExample {
    init {
        println("created!")
    }

    val lazyStr: String by lazy {
        println("computed!")
        "my lazy"
    }
}

class User2(val map:Map<String, Any?>){
    val name: String by map
    val age: Int by map
}