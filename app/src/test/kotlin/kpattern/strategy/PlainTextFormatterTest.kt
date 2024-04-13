package kpattern.strategy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlainTextFormatterTest {

    @Test
    fun testFormat_MoreThan80Chars_success() {
        val input =
            "This is a string that is more than 80 characters long. It should be wrapped onto multiple lines."
        val expected = """
            This is a string that is more than 80 characters long. It should be wrapped onto
            multiple lines.
        """.trimIndent()
        assertEquals(expected, PlainTextFormatter().format(input))
    }

    @Test
    fun testFormat_LessThan80Chars_success() {
        val input = "This is an example of text justification."
        val expected = """
            This is an example of text justification.
        """.trimIndent()
        assertEquals(expected, PlainTextFormatter().format(input))
    }

    @Test
    fun testFormat_multipleLinesWithPunctuations() {
        val input =
            "This is a string that contains punctuation. It should be wrapped onto multiple lines, and the punctuation should be preserved."
        val expectation = """
            This is a string that contains punctuation. It should be wrapped onto multiple
            lines, and the punctuation should be preserved.
        """.trimIndent()
        assertEquals(expectation, PlainTextFormatter().format(input))
    }

    @Test
    fun testFormat_exactly80CharactersLong() {
        val input = "This is a string that is exactly 80 characters long."
        val expectation = "This is a string that is exactly 80 characters long."
        assertEquals(expectation, PlainTextFormatter().format(input))
    }
}