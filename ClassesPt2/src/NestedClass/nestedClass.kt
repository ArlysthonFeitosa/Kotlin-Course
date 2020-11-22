package NestedClass

class Computer(val processorModel: String) {

    inner class Memory {
        fun getMemoryLevel(): Int {
            println(processorModel)
            return 70
        }
    }
}

fun main(args: Array<String>) {
    val m1: Computer.Memory = Computer("Intel").Memory()
    m1.getMemoryLevel()
}