package top.takuron.ncpuy.tools.crypto

import top.takuron.ncpuy.tools.utils.TerminalUtils
import java.lang.Exception

fun main(args: Array<String>) {
    TerminalUtils.buildMenu(listOf("Generate aes key","Aes encrypt","Aes decrypt"),{
        println("--------------------")
        when(it){
            0 -> generateKey()
            1 -> aesEncrypt()
            2 -> aesDecrypt()
        }
    })
}

private fun generateKey(){
    var size = 128
    println("Please input size(default:256)")
    val input = readln()
    if(input.toIntOrNull()!=null)  size = input.toInt()

    println("Your key is:")
    println(CryptoUtils.genSecret("AES",size))
    println("Input anything to exit")
    readln()
}

private fun aesEncrypt(){
    val helper = CipherHelper(
        CipherInfo(
        "AES",
        "AES/ECB/PKCS5Padding",
        Charsets.UTF_8
    ))
    println("Please input your key:")
    helper.key = readln()

    try {
        val sample = helper.encryptToBase64("exit")
        println("Encrypt success, example:")
        println("exit -> ${sample}")
    } catch (e:Exception){
        println("Error key")
        return
    }


    println("--------------------")
    println("Input text you want to encrypt, exit with input \"exit\"")
    while(true){
        val source = readln()
        if(source!="exit") println(helper.encryptToBase64(source))
        else return
    }
}

private fun aesDecrypt(){
    val helper = CipherHelper(
        CipherInfo(
            "AES",
            "AES/ECB/PKCS5Padding",
            Charsets.UTF_8
        ))
    println("Please input your key:")
    helper.key = readln()

    try {
        val sample = helper.encryptToBase64("exit")
        println("Decrypt success, example:")
        println("${sample} -> ${helper.decryptFromBase64(sample)}")
    } catch (e:Exception){
        println("Error key")
        return
    }


    println("--------------------")
    println("Input text you want to decrypt, exit with input \"exit\"")
    while(true){
        val source = readln()
        if(source!="exit"){
            try {
                println(helper.decryptFromBase64(source))
            } catch (e:Exception){
                println("Error: not currect encrype text")
            }
        }
        else return
    }
}