package name.nepavel.yandex_speller

import name.nepavel.yandex_speller.model.Option
import org.junit.Test

class YandexSpellerServiceTest {
    private val service = YandexSpellerService()
    @Test
    fun checkText() {
        //TBD
        val spellResult = service.checkText("I am texd with with miztakes", options = arrayOf(Option.FIND_REPEAT_WORDS))
        println(spellResult)
    }

    @Test
    fun checkTexts() {
        //TBD
        val spellResults = service.checkTexts(arrayOf("Превед медвед я криветка", "в дуюбне лютыи марозы"))
        println(spellResults)
    }
}