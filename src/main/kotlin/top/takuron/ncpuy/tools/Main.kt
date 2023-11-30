package top.takuron.ncpuy.tools

import top.takuron.ncpuy.tools.utils.TerminalUtils

val NCPUY_TITLE = "Ncpuy Tools v1.1.0003\nhttps://github.com/takuron/NcpuyTools"

fun main(args: Array<String>) {
    TerminalUtils.buildMenu(listOf("Crypto tools","Proguard generater"), {
        when (it) {
            0 -> top.takuron.ncpuy.tools.crypto.main(args)
            1 -> top.takuron.ncpuy.tools.proguard.main(args)
        }
    }, NCPUY_TITLE)
}