package com.heartbeat.clientApi.util;

/**
 * Created with IntelliJ IDEA.
 * User: saji
 * Date: 6/4/13
 * Time: 12:52 PM
 * Encapsulates all exceptions during encryption/decryption using EncryptionUtil
 */
public class EncryptionException extends Exception {
    public EncryptionException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
