package kpattern.singleton

import org.junit.jupiter.api.Test

class SingletonTest {

    @Test
    fun testSingleton() {
        val firstDatabase = DatabaseSingleton.database()
        val secondDatabase = DatabaseSingleton.database()

        assert(firstDatabase == secondDatabase)
    }
}