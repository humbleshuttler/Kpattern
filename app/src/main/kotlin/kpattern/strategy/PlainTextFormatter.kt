package kpattern.strategy

/**
 * Formats the text into standard text format that contains a maximum of 80 characters per line.
 */
class PlainTextFormatter : TextFormatter {

    companion object {
        private const val WIDTH = 80
    }

    override fun format(text: String): String {
        val words = text.split(" ")
        val lines = mutableListOf<String>()
        val currentLine = StringBuilder()
        for (word in words) {
            if (currentLine.length + word.length + 1 > WIDTH) {
                lines.add(currentLine.toString())
                currentLine.clear()
            }
            if (currentLine.isEmpty()) {
                currentLine.append(word)
            } else {
                currentLine.append(" $word")
            }
        }
        lines.add(currentLine.toString())
        return lines.joinToString(separator = "\n")
    }
}