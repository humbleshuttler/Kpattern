package kpattern.singleton

object DatabaseSingleton {

    private var isConnected: Boolean = false

    init {
        println("Connecting to database...")
        isConnected = true
    }

    fun database(): DatabaseSingleton {
        return this
    }
}