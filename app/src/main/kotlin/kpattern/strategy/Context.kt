package kpattern.strategy

class Context {

    private val context = mutableMapOf<String, String>()

    fun set(key: String, value: String) {
        context[key] = value
    }

    fun get(key: String): String? {
        return context[key]
    }
}