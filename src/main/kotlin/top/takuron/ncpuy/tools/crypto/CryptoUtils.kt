package top.takuron.ncpuy.tools.crypto

import android.util.Base64
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import javax.crypto.KeyGenerator

object CryptoUtils {
    /**
     * Genrate secret key
     *
     * @author takuron
     *
     * @param algorithm algorithm ect AES
     * @param size key size,ect 128 256
     */
    fun genSecret(algorithm: String,size:Int = 256): String = try {
        val kg = KeyGenerator.getInstance(algorithm).apply {
            init(size,SecureRandom())
        }
        Base64.encodeToString(kg.generateKey().encoded, Base64.NO_WRAP)
    } catch (e: NoSuchAlgorithmException) {
        throw e
    }
}
