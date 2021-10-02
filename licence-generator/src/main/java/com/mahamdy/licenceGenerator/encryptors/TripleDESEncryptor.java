package com.mahamdy.licenceGenerator.encryptors;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class TripleDESEncryptor {

    private final String key = "qgXG*P>Y~_9b(u~*p~Uv-n>#a@a=(fu.d'n-n~Ed_=e4edwkd8E(*hL\"}CW7z&MCFYhJQDMKqS=mMgwG%RfRZRaP!Xc[mQkR`j:LMv#S4X4}W&EtfLZW)2]C{_jhBuRq";

    private final String UNICODE_FORMAT = "UTF8";
    private final String encryptionScheme = "DESede";
    private SecretKeyFactory secretKeyFactory;
    private SecretKey secretKey;
    private Cipher cipher;
    private KeySpec keySpec;

    public TripleDESEncryptor() {
        try {
            cipher = Cipher.getInstance(encryptionScheme);
            secretKeyFactory = SecretKeyFactory.getInstance(encryptionScheme);
            keySpec = new DESedeKeySpec(key.getBytes(UNICODE_FORMAT));
            secretKey = secretKeyFactory.generateSecret(keySpec);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | InvalidKeyException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String unencryptedText) {
        String encryptedTxt = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] tripleDESEncryptedText = cipher.doFinal(unencryptedText.getBytes(UNICODE_FORMAT));
            BASE64Encoder base64encoder = new BASE64Encoder();
            encryptedTxt = base64encoder.encode(tripleDESEncryptedText);
            System.err.println("After 3-DES Encryption : " + encryptedTxt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedTxt;
    }

    private String decrypt(String encryptedText) {
        String decryptedTxt = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            BASE64Decoder base64decoder = new BASE64Decoder();
            byte[] encryptedTxt = base64decoder.decodeBuffer(encryptedText);
            byte[] plainText = cipher.doFinal(encryptedTxt);
            decryptedTxt = new String(plainText, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedTxt;
    }

}
