package top.takuron.ncpuy.tools.crypto

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.security.InvalidAlgorithmParameterException
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.spec.SecretKeySpec

/**
 * CipherHelper's info
 *
 * @author takuron
 * @d
 *
 * @param algorithm
 */
data class CipherInfo(
    val algorithm: String = "AES",
    val transformation: String = "AES/ECB/PKCS5Padding",
    val charset: Charset = Charsets.UTF_8
)

/**
 * A simple helper class to make encrypt/decrypt easier.
 *
 * @author takuron
 *
 * @param info Encrypt/decrypt algorithm and charset info
 */

class CipherHelper(val info: CipherInfo) {

    /**
     * encryption key
     *
     * Set it before encrypt/decrypt
     * @author takuron
     */

    var key = ""

    private val keyInByte get() = key.toByteArray(info.charset)

    /**
     * encrypt and base46
     *
     * @param data source
     * @return encrypted base64
     */
    fun encryptToBase64(data: String): String {
        val valueByte = encrypt(data.toByteArray(info.charset), keyInByte)
        return encodeBase64(valueByte!!)
    }

    /**
     * decrypt and base46
     *
     * @param data encrypted base64
     * @return source
     */
    fun decryptFromBase64(data: String): String = decrypt(decodeBase64(data), keyInByte)

    /**
     * Encrypt
     *
     * @param data source
     * @return encrypt text
     */
    fun encrypt(data: ByteArray, keyInByte: ByteArray): ByteArray? {
        val keySpec = SecretKeySpec(this.keyInByte, info.algorithm)
        val cipher = Cipher.getInstance(info.transformation)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec)
        return cipher.doFinal(data)
        return null
    }

    /**
     * Decrypt
     *
     * @param data encrypt text
     * @param key  key
     * @return source
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     */
    fun decrypt(data: ByteArray, keyInByte: ByteArray): String {
        val keySpec = SecretKeySpec(this.keyInByte, info.algorithm)
        val cipher = Cipher.getInstance(info.transformation)
        cipher.init(Cipher.DECRYPT_MODE, keySpec)
        val result = cipher.doFinal(data)
        return String(result, info.charset)
    }

    /**
     * Encoded as Base64
     *
     * Implemented using android.util.Base64 library
     *
     * @param input source
     * @return base64 text
     */
    private fun encodeBase64(input: ByteArray): String = Base64.encodeToString(input, Base64.NO_WRAP)

    /**
     * Decoded as Base64
     *
     * Implemented using android.util.Base64 library
     *
     * @param input base64 text
     * @return source
     * @throws UnsupportedEncodingException
     */
    private fun decodeBase64(input: String): ByteArray {
        return Base64.decode(input.toByteArray(info.charset), Base64.NO_WRAP)
    }

}