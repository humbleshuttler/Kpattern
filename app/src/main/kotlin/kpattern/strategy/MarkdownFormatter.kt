package kpattern.strategy

class MarkdownFormatter:TextFormatter {
    override fun format(text: String): String {
        return "markdown formatting"
    }
}