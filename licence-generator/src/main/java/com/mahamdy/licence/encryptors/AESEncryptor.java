package com.mahamdy.licence.encryptors;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESEncryptor {

    private final String key = "A@e3%lmw_tBP5fOr";

    private final String UNICODE_FORMAT = "UTF8";
    private SecretKeySpec aesSecretKey;
    private Cipher cipher;

    public AESEncryptor() {
        try {
            aesSecretKey = new SecretKeySpec(key.getBytes(UNICODE_FORMAT), "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String unencryptedText) {
        String encryptedTxt = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, aesSecretKey, new IvParameterSpec(new byte[16]));
            byte[] AESEncryptedText = cipher.doFinal(unencryptedText.getBytes(UNICODE_FORMAT));
            BASE64Encoder base64encoder = new BASE64Encoder();
            encryptedTxt = base64encoder.encode(AESEncryptedText);
            System.err.println("After AES Encryption : " + encryptedTxt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedTxt;
    }

    public String decrypt(String encryptedText) {
        String decryptedText = null;
        try {
            Base64.Decoder decoder = Base64.getMimeDecoder();
            byte[] encryptedTextByte = decoder.decode(encryptedText);
            cipher.init(Cipher.DECRYPT_MODE, aesSecretKey, new IvParameterSpec(new byte[16]));
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            decryptedText = new String(decryptedByte, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
}
