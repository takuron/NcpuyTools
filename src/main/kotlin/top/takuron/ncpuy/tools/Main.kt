package top.takuron.ncpuy.tools

import top.takuron.ncpuy.tools.utils.TerminalUtils

val NCPUY_TITLE = "Ncpuy Tools v1.1.0001\n"

fun main(args: Array<String>) {
    TerminalUtils.buildMenu(listOf("Crypto tools"), {
        when (it) {
            0 -> top.takuron.ncpuy.tools.crypto.main(args)
        }
    }, NCPUY_TITLE)
}