package top.takuron.ncpuy.tools.proguard

import top.takuron.ncpuy.tools.utils.TerminalUtils

const val TERMINAL_TITLE = "Choose proguard rules you wants to generate"
fun main(args: Array<String>) {
    TerminalUtils.buildMenu(listOf("Custome","Japanese katakana","Japanese hiragana","German","Greek","Russian","Chinese Simplify"),{
        when(it){
            0 -> personalProgurad()
            1 -> SpecificCharacterProguard("proguard-jp-ka.txt", "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん").create()
            2 -> SpecificCharacterProguard("proguard-jp-hr.txt", "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン").create()
            3 -> SpecificCharacterProguard("proguard-ge.txt", "AaÄäBbCcDdEeFfGgHhIiJjKkLlMmNnOoÖöPpQqRrSsẞßTtUuÜüVvWwXxYyZz").create()
            4 -> SpecificCharacterProguard("proguard-gr.txt", "ΑαΒβΓγΔδΕεϵϜϝΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσςΤτΥυΦφϕΧχΨψΩω").create()
            5 -> SpecificCharacterProguard("proguard-ru.txt", "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя").create()
            6 -> SpecificCharacterProguard("proguard-cn.txt", "众请我何生还母爸跟姐我捡请次本哭抱岁遍床放鞋阿呢奇洗才课骑连刀圆护插贵向坏验诉秒谢鼻望黑飞男警饿假表深改碰留窗责散楚址收忘击院等鸡拉狗族船忙者展味曾牛兄讲姑友呼麻刚命院刀科狼走字感汉技村主空练饿好店鱼数门久真答此购欢宾忙讲梦四跳姑女界部趣盖觉吃泪船顺界票船充城黄闭示词友桥买板剧意集坏盘拿啦世热窗太闭邮速教将种使送念睡太命花吸拿千姑看刚学姐颜却球油充刷常想更营要友忆约笑说哈热学好光船口往赛耳令枪回意剧发语终车给验供外房起动觉船书忙嘴鼻纸语养纸问").create()
        }
    }, TERMINAL_TITLE)
}

private fun personalProgurad(){    print("Please enter your file name:")
    val filename = readln()
    println("Please enter your chars:")
    val chars = readln()

    SpecificCharacterProguard(filename, chars).create()
}