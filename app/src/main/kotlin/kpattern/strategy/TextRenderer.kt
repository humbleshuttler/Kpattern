package kpattern.strategy

/**
 * Renders input text as per the text type. See [textFormatters] for list of supported formatters.
 */
class TextRenderer {

    private val textFormatters: Map<String, TextFormatter> = mapOf(
        "plain" to PlainTextFormatter(),
        "html" to HtmlFormatter(),
        "markdown" to MarkdownFormatter()
    )

    fun render(context: Context, input: String): String {
        val textType = context.get("text_type")
        if (textType == null || !textFormatters.containsKey(textType)) {
            throw IllegalArgumentException("Unable to identify input text type. Set a valid text_type in context")
        }
        return textFormatters[textType]!!.format(input)
    }
}