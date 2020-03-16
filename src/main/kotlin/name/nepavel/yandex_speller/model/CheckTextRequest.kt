package name.nepavel.yandex_speller.model

class CheckTextRequest(val text: String, langs: Array<Lang> = emptyArray(), options: Array<Option> = emptyArray(), format: Format = Format.PLAIN) {
    val lang = langs.joinToString(",") { it.text }
    val options = options.sumBy { it.num }
    val format = format.text
}
