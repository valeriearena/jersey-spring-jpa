package com.heartbeat.clientApi.util;

import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.Security;

/**
 * Created with IntelliJ IDEA.
 * User: saji
 * Date: 5/10/13
 * Time: 3:01 PM
 * This utility class includes static methods for data encryption and decryption.
 */
public class EncryptionUtil {

    private static Key generateKeySpec(String key) throws UnsupportedEncodingException {
        if(key.length()!=32) throw new UnsupportedEncodingException("Key should be exactly 32 characters");
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        byte[] keyBytes = key.getBytes("UTF-8");

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        return keySpec;
    }

    /**
     * Encrypts the given string using AES 256 bit using the supplied key and returns the result as a Base64 encoded string.
     * Note that this method is compatible with the MH iOS client encrypt/decrypt functions
     * @param toEncrypt - string to encrypt
     * @param key - the key for encryption. Must be 32 characters long
     * @return - encrypted data as a Base64 encoded string
     * @throws Exception
     */
    public static String encryptAES256(String toEncrypt, String key) throws EncryptionException {
        try {
            Key skeySpec = generateKeySpec(key);
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(toEncrypt.getBytes("UTF-8"));
            byte[] encryptedValue = Base64.encode(encrypted);
            return new String(encryptedValue,"UTF-8");
        } catch (Exception e) {
            throw new EncryptionException("Error while decrypting text",e);
        }
    }

    /**
     * Decrypts the given Base64 encoded string using AES 256 bit using the supplied key and returns the result(original string)
     * Note that this method is compatible with the MH iOS client encrypt/decrypt functions
     * @param toDecrypt - Base64 encoded, AES 256 encrypted string
     * @param key - key that was used to encrypt the original string
     * @return - Original string that was encrypted
     * @throws Exception
     */
    public static String decryptAES256(String toDecrypt, String key) throws EncryptionException {

        try {
            Key skeySpec = generateKeySpec(key);
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] decodedBytes = Base64.decode(toDecrypt.getBytes("UTF-8"));
            byte[] original = cipher.doFinal(decodedBytes);
            return new String(original,"UTF-8");
        } catch (Exception e) {
            throw new EncryptionException("Error while encrypting text",e);
        }
    }

    public static String encryptSHA256(String toEncrypt) throws EncryptionException  {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return new String(Base64.encode(digest.digest(toEncrypt.getBytes())));
        }
        catch (Exception e) {
            throw new EncryptionException("Error while encrypting text", e);
        }
    }

    public static void main(String[] args){
        try {
            //String value = encryptAES256("valerie", "HE^OnYUORkKoH1X7J^YiqF#mRB2NH52*");

            String value = decryptAES256("eiGPtqOj1dEgkFyZdm3HPA==", "HE^OnYUORkKoH1X7J^YiqF#mRB2NH52*");

            System.out.println(value);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
