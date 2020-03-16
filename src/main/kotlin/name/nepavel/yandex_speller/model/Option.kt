package name.nepavel.yandex_speller.model

enum class Option(val num: Int) {
    IGNORE_DIGITS(2), IGNORE_URLS(4), FIND_REPEAT_WORDS(8), IGNORE_CAPITALIZATION(512)
}