package name.nepavel.yandex_speller

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.submitForm
import io.ktor.http.Parameters
import kotlinx.coroutines.runBlocking
import name.nepavel.yandex_speller.model.*
import org.json.JSONObject
import java.io.InputStream
import java.util.*

class YandexSpellerService {
    private val client = HttpClient()
    private val gson = Gson()
    private val properties = Properties().apply { load("/endpoints.properties".asResource()) }

    fun checkText(
        text: String,
        langs: Array<Lang> = emptyArray(),
        options: Array<Option> = emptyArray(),
        format: Format = Format.PLAIN
    ): SpellResult {
        val jsonString = runBlocking {
            client.submitForm<String>(
                properties["checkTextUrl"] as String,
                formParameters = Parameters.build {
                    JSONObject(CheckTextRequest(text, langs, options, format)).toMap().forEach { (k, v) ->
                        append(k, v.toString())
                    }
                }
            )
        }
        return SpellResult(gson.fromJson(jsonString, Array<Error>::class.java).toList())
    }

    fun checkTexts(
        text: Array<String>,
        langs: Array<Lang> = emptyArray(),
        options: Array<Option> = emptyArray(),
        format: Format = Format.PLAIN
    ): List<SpellResult> {
        val jsonString = runBlocking {
            client.submitForm<String>(
                properties["checkTextsUrl"] as String,
                formParameters = Parameters.build {
                    JSONObject(CheckTextsRequest(text, langs, options, format)).toMap().forEach { (k, v) ->
                        append(k, v.toString())
                    }
                }
            )
        }
        return gson.fromJson(jsonString, Array<Array<Error>>::class.java).map { SpellResult(it.toList()) }
    }

    private fun String.asResource(): InputStream {
        return this.javaClass::class.java.getResource(this).openStream()
    }
}