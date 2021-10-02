package com.mahamdy.licence.encryptors;

import com.mahamdy.licence.utilities.Replacer;

public class SimpleEncryptor extends Replacer {

    public String encrypt(String password) {
        char[] passwordCharArr = password.toLowerCase().toCharArray();
        for (int x = 0; x <= passwordCharArr.length - 1; x++) {
            passwordCharArr[x] = replaceLetter(passwordCharArr[x], "Change");
        }
        return new String(passwordCharArr);
    }

    public String decrypt(String password) {
        char[] passwordCharArr = password.toLowerCase().toCharArray();
        for (int x = 0; x <= passwordCharArr.length - 1; x++) {
            passwordCharArr[x] = replaceLetter(passwordCharArr[x], "Re-Change");
        }
        return new String(passwordCharArr);
    }
}
