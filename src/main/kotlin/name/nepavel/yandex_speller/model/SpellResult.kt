package name.nepavel.yandex_speller.model

class SpellResult(errors: List<Error>) {
    val errors: List<SpellerError> = errors.map { SpellerError(it) }

    override fun toString(): String {
        return errors.toString()
    }
}