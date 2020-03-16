## Simple JSON client for Yandex Speller  
Any improvements are welcome!  

### Configuring
Endpoints are located at classpath resources file `endpoints.properties`  

### Usage
    val service = YandexSpellerService()
    val spellResult: SpellResult = service.checkText(
        "I am texd with with miztakes",
        options = arrayOf(Option.FIND_REPEAT_WORDS)
    )  
  
### See also
https://yandex.ru/dev/speller/doc/dg/concepts/api-overview-docpage/