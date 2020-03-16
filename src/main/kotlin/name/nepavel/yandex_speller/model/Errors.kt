package name.nepavel.yandex_speller.model

data class Error(
    val code: Int,
    val pos: Int,
    val row: Int,
    val col: Int,
    val len: Int,
    val word: String,
    val s: List<String>
)

data class SpellerError(private val error: Error) {
    val code: ErrorCode = ErrorCode.values().single { it.code == error.code }
    val pos: Int
        get() = error.pos
    val row: Int
        get() = error.row
    val col: Int
        get() = error.col
    val len: Int
        get() = error.len
    val word: String
        get() = error.word
    val s: List<String>
        get() = error.s

    override fun toString(): String {
        return "SpellerError(code=${code.text}, pos=$pos, row=$row, col=$col, len=$len, word=$word, s=$s)"
    }


}

enum class ErrorCode(val code: Int, val text: String) {
    ERROR_UNKNOWN_WORD(1, "Слова нет в словаре"),
    ERROR_REPEAT_WORD(2, "Повтор слова"),
    ERROR_CAPITALIZATION(3, "Неверное употребление прописных и строчных букв"),
    ERROR_TOO_MANY_ERRORS(4, "Текст содержит слишком много ошибок")
}