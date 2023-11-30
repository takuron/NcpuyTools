package top.takuron.ncpuy.tools.proguard

import top.takuron.ncpuy.tools.utils.TerminalUtils

const val TERMINAL_TITLE = "Choose proguard rules you wants to generate"
fun main(args: Array<String>) {
    TerminalUtils.buildMenu(listOf("Custome","Japanese hiragana","German","Greek","Russian"),{
        when(it){
            0 -> personalProgurad()
            1 -> SpecificCharacterProguard("proguard-jp.txt", "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん").create()
            2 -> SpecificCharacterProguard("proguard-ge.txt", "AaÄäBbCcDdEeFfGgHhIiJjKkLlMmNnOoÖöPpQqRrSsẞßTtUuÜüVvWwXxYyZz").create()
            3 -> SpecificCharacterProguard("proguard-gr.txt", "ΑαΒβΓγΔδΕεϵϜϝΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσςΤτΥυΦφϕΧχΨψΩω").create()
            4 -> SpecificCharacterProguard("proguard-ru.txt", "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя").create()
        }
    }, TERMINAL_TITLE)
}

private fun personalProgurad(){
    print("Please enter your file name:")
    val filename = readln()
    println("Please enter your chars:")
    val chars = readln()

    SpecificCharacterProguard(filename, chars).create()
}