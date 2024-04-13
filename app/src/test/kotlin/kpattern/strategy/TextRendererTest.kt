package kpattern.strategy

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TextRendererTest {

    @Test
    fun testRender_singleSingleType() {
        val rendered = TextRenderer()
        val context = Context()
        context.set("text_type", "plain")
        val input = "This is a simple text."
        val expected = "This is a simple text."

        val actual = rendered.render(context, input)

        assertEquals(expected, actual)
    }

    @Test
    fun testRender_multiSingleType() {
        val rendered = TextRenderer()
        val context = Context()
        context.set("text_type", "plain")
        val input1 = "This is a simple text."
        val expected1 = "This is a simple text."

        val actual1 = rendered.render(context, input1)
        assertEquals(expected1, actual1)

        val input2 = "This is a simple text."
        val expected2 = "This is a simple text."
        val actual2 = rendered.render(context, input2)
        assertEquals(expected2, actual2)
    }

    @Test
    fun testRender_multipleMultiType() {
        val rendered = TextRenderer()
        val context = Context()
        context.set("text_type", "plain")
        val input1 = "This is a simple text."
        val expected1 = "This is a simple text."

        val actual1 = rendered.render(context, input1)
        assertEquals(expected1, actual1)

        val input2 = "<b>this is html bold text.</b>"
        val expected2 = "formatting html"
        context.set("text_type", "html")
        val actual2 = rendered.render(context, input2)
        assertEquals(expected2, actual2)
    }

    @Test
    fun testRender_typeNotAvailable() {
        val rendered = TextRenderer()
        val context = Context()
        val input = "This is a simple text."

        assertThrows<IllegalArgumentException> {
            rendered.render(
                context,
                input
            )
        }
    }

    @Test
    fun testRender_invalidType() {
        val rendered = TextRenderer()
        val context = Context()
        context.set("text_type", "xml")
        val input = "This is a simple text."

        assertThrows<IllegalArgumentException> {
            rendered.render(
                context,
                input
            )
        }
    }
}