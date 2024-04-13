package kpattern.strategy

import org.jsoup.Jsoup

class HtmlFormatter : TextFormatter {

    override fun format(text: String): String {
        return ("formatting html")
    }
}