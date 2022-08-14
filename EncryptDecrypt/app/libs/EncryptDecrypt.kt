package com.example.encryptdecrypt

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object EncryptDecrypt {
    init {
        println("Start EncryptDecrypt with singleton")
    }
    // This function to create an encrypted string being base64 encoded
    internal fun encrypt(data: String, key: String, iv: String, algorithms: String = "AES/CBC/PKCS5Padding"): String {
        try {
            val currentTimestamp: Long = System.currentTimeMillis()
            val seconds = currentTimestamp / 1000 % 60

            println("This time to see encrypt: $seconds seconds")
            // This to create parameters key and iv this important because this data have to keep to decrypt
            val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
            // This to create cipher to encrypt data and parse algorithm we want to use
            val cipher = Cipher.getInstance(algorithms)
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)
            // this function to encrypt data being base64 encoded and bytes
            val cipherText = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
            // This to return and create cipher was being change to string
            return Base64.encodeToString(cipherText, Base64.DEFAULT)
//            return Base64.getEncoder().encodeToString(cipherText)
        } catch (e: Exception) {
            println("Start err in Encrypt Function")
            e.printStackTrace()
            println("End err Encrypt Function")
        }
        return "something wrong"
    }

    //This function to  decrypt data form hexadecimal at server
    internal fun decrypt(dataCipher: String, key: String, iv: String, algorithms: String = "AES/CBC/PKCS5Padding"): String {
        try {
            val currentTimestamp: Long = System.currentTimeMillis()
            val seconds = currentTimestamp / 1000 % 60

            println("This time to see decrypt: $seconds seconds")
            // This to create parameters key and iv this important because this data have to keep to decrypt
            val secretKeySpec = SecretKeySpec(key.toByteArray(),  "AES")
            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
            // This to create cipher to decrypt data and parse algorithm we want to use
            val cipher = Cipher.getInstance(algorithms)
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)
            // This if selection to check the algorithm used BASE64
            return if (dataCipher.contains("=")) {
                val plainText = cipher.doFinal(Base64.decode(dataCipher, Base64.DEFAULT))
                // This to return and create cipher was being change to string
                String(plainText)
                //This else selection to check the algorithm used Hexadecimal
            } else {
                // This to decrypt data being base64 encoded and bytes
                val bytes = dataCipher.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
                val encodedHexB64 = Base64.encodeToString(bytes, Base64.DEFAULT)
                val plainText = cipher.doFinal(Base64.decode(encodedHexB64, Base64.DEFAULT))
                // This to return and create cipher was being change to string
                String(plainText)
            }
        } catch (e: Exception) {
            println("Start err Decrypt Function")
            e.printStackTrace()
            println("End err Decrypt Function")
        }
        return "something wrong"
    }
}



//class  EncryptDecrypt{
//    // This function to create an encrypted string being base64 encoded
////    @RequiresApi(Build.VERSION_CODES.O)
//    fun encrypt(data: String, key: String, iv: String, algorithms: String = "AES/CBC/PKCS5Padding"): String {
//        try {
//            val currentTimestamp: Long = System.currentTimeMillis()
//            val seconds = currentTimestamp / 1000 % 60
//
//            println("This time to see encrypt: $seconds seconds")
//            // This to create parameters key and iv this important because this data have to keep to decrypt
//            val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
//            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
//            // This to create cipher to encrypt data and parse algorithm we want to use
//            val cipher = Cipher.getInstance(algorithms)
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)
//            // this function to encrypt data being base64 encoded and bytes
//            val cipherText = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
//            // This to return and create cipher was being change to string
//            return Base64.encodeToString(cipherText, Base64.DEFAULT)
////            return Base64.getEncoder().encodeToString(cipherText)
//        } catch (e: Exception) {
//            println("Start err in Encrypt Function")
//            e.printStackTrace()
//            println("End err Encrypt Function")
//        }
//        return "something wrong"
//    }
//
////     This function to  decrypt data form hexadecimal at server
////    @RequiresApi(Build.VERSION_CODES.O)
//        fun decrypt(dataCipher: String, key: String, iv: String, algorithms: String = "AES/CBC/PKCS5Padding"): String {
//        try {
//            val currentTimestamp: Long = System.currentTimeMillis()
//            val seconds = currentTimestamp / 1000 % 60
//
//            println("This time to see decrypt: $seconds seconds")
//            // This to create parameters key and iv this important because this data have to keep to decrypt
//            val secretKeySpec = SecretKeySpec(key.toByteArray(),  "AES")
//            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
//            // This to create cipher to decrypt data and parse algorithm we want to use
//            val cipher = Cipher.getInstance(algorithms)
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)
//            // This if selection to check the algorithm used BASE64
//            return if (dataCipher.contains("=")) {
//                val plainText = cipher.doFinal(Base64.decode(dataCipher, Base64.DEFAULT))
//                // This to return and create cipher was being change to string
//                String(plainText)
//                //This else selection to check the algorithm used Hexadecimal
//            } else {
//                // This to decrypt data being base64 encoded and bytes
//                val bytes = dataCipher.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
//                val encodedHexB64 = Base64.encodeToString(bytes, Base64.DEFAULT)
//                val plainText = cipher.doFinal(Base64.decode(encodedHexB64, Base64.DEFAULT))
//                // This to return and create cipher was being change to string
//                String(plainText)
//            }
//        } catch (e: Exception) {
//            println("Start err Decrypt Function")
//            e.printStackTrace()
//            println("End err Decrypt Function")
//        }
//        return "something wrong"
//    }
//}
//



//object  GFG
//{
//    init
//    {
//        println("Singleton class invoked.")
//    }
//
//    var name = "GFG Is Best"
//    fun add(num1:Int,num2:Int):Int
//    {
//        return num1.plus(num2)
//    }
//}

//package com.example.encryptdecrypt
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import java.util.*
//import javax.crypto.Cipher
//import javax.crypto.spec.IvParameterSpec
//import javax.crypto.spec.SecretKeySpec
//
//open class EncryptDecrypt {
//    // This function to create an encrypted string being base64 encoded
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun encrypt(data: String, key: String, iv: String, algorithms: String = "AES/CBC/PKCS5Padding"): String {
//        try {
//            val currentTimestamp: Long = System.currentTimeMillis()
//            val seconds = currentTimestamp / 1000 % 60
//
//            println("This time to see encrypt: $seconds seconds")
//            // This to create parameters key and iv this important because this data have to keep to decrypt
//            val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
//            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
//            // This to create cipher to encrypt data and parse algorithm we want to use
//            val cipher = Cipher.getInstance(algorithms)
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)
//            // this function to encrypt data being base64 encoded and bytes
//            val cipherText = cipher.doFinal(data.toByteArray(Charsets.UTF_8))
//            // This to return and create cipher was being change to string
//            return Base64.getEncoder().encodeToString(cipherText)
//        } catch (e: Exception) {
//            println("Start err in Encrypt Function")
//            e.printStackTrace()
//            println("End err Encrypt Function")
//        }
//        return "something wrong"
//    }
//
//    // This function to  decrypt data form hexadecimal at server
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun decrypt(dataCipher: String, key: String, iv: String, algorithms: String = "AES/CBC/PKCS5Padding"): String {
//        try {
//            val currentTimestamp: Long = System.currentTimeMillis()
//            val seconds = currentTimestamp / 1000 % 60
//
//            println("This time to see decrypt: $seconds seconds")
//            // This to create parameters key and iv this important because this data have to keep to decrypt
//            val secretKeySpec = SecretKeySpec(key.toByteArray(),  "AES")
//            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
//            // This to create cipher to decrypt data and parse algorithm we want to use
//            val cipher = Cipher.getInstance(algorithms)
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)
//            // This if selection to check the algorithm used BASE64
//            return if (dataCipher.contains("=")) {
//                val plainText = cipher.doFinal(Base64.getDecoder().decode(dataCipher))
//                // This to return and create cipher was being change to string
//                String(plainText)
//                //This else selection to check the algorithm used Hexadecimal
//            } else {
//                // This to decrypt data being base64 encoded and bytes
//                val bytes = dataCipher.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
//                val encodedHexB64 = Base64.getEncoder().encodeToString(bytes)
//                val plainText = cipher.doFinal(Base64.getDecoder().decode(encodedHexB64))
//                // This to return and create cipher was being change to string
//                String(plainText)
//            }
//        } catch (e: Exception) {
//            println("Start err Decrypt Function")
//            e.printStackTrace()
//            println("End err Decrypt Function")
//        }
//        return "something wrong"
//    }
//}
//
