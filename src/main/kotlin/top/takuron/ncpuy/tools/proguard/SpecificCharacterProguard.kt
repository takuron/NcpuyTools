package top.takuron.ncpuy.tools.proguard

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import kotlin.math.ln
import kotlin.math.max


const val MIN_LEN = 5
class SpecificCharacterProguard(private val fileName: String, private val chars: CharArray) {

    constructor(fileName: String,chars:String) : this(fileName,chars.toCharArray())

    private val len: Int by lazy { max(8.0, (ln(8000.0) / ln(chars.size.toDouble()) * 1.5).toInt().toDouble()).toInt() }
    private val list: MutableList<String> = ArrayList()

    fun create() {
        println("Start create proguard file")
        try {
            val f = File(fileName)
            if(f.exists()) f.delete()
        } catch (e:Exception){
            println("Error edit file")
            e.printStackTrace()
            return
        }

        var i = 0
        while (i < 8000) {
            val len = (MIN_LEN + Math.random() * len).toInt()
            val k = StringBuilder()
            for (i1 in 0..<len) {
                k.append(getRadomChar(i1 == 0))
            }
            val s = k.toString()

            if (list.contains(s)) continue

            list.add(s)
            appendFile(fileName, s)
            i +=1
        }

        println("Finish")
    }

    private fun getRadomChar(firstChar: Boolean): Char {
        val aChar = chars[(Math.random() * chars.size).toInt()]
        return if (firstChar && aChar >= '0' && aChar <= '9') {
            getRadomChar(firstChar)
        } else aChar
    }

    private fun appendFile(file: String, conent: String) {
        var out: BufferedWriter? = null
        try {
            out = BufferedWriter(
                OutputStreamWriter(
                    FileOutputStream(file, true)
                )
            )
            out.write(conent + "\r\n")
        } catch (e: Exception) {
            println("Error write file")
            e.printStackTrace()
        } finally {
            try {
                out!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}

