package com.mahamdy.licence;

import com.mahamdy.licence.encryptors.AESEncryptor;
import com.mahamdy.licence.encryptors.SimpleEncryptor;
import com.mahamdy.licence.encryptors.TripleDESEncryptor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LicenceGeneratorTest {
    private final String encryptedPcID = "c82heie5j#f5qxzaui#8dj4bwu 50c8bo w ce34b wr ij4ff8d6 u#s#u";
    private SimpleEncryptor simpleEncryptor;
    private TripleDESEncryptor tripleDESEncryptor;
    private AESEncryptor aesEncryptor;

    @Before
    public void setup() {
        simpleEncryptor = new SimpleEncryptor();
        tripleDESEncryptor = new TripleDESEncryptor();
        aesEncryptor = new AESEncryptor();
    }

    @Test
    public void shouldDecryptLicenceAtFullCylce() {

        String decryptedPcID = simpleEncryptor.decrypt(encryptedPcID);
        Assert.assertEquals("microsoft#pf079k4s#intel64 family 6 model 61 stepping 4#2#4", decryptedPcID);

        String dataToEncrypt = "01/01/2021-01/01/2022-50-" + decryptedPcID;
        String encryptedTxt = aesEncryptor.encrypt(tripleDESEncryptor.encrypt(dataToEncrypt));
        Assert.assertEquals("cpS5pKT4xmXXqqUkLGi1qFhdn+LPh1m3DB29sDMZPpnuxTeCGRd39XRbwFQ4Shy+EhPDN75eL54z\n" +
                "vT3go4JfhSreiY5sOMGhrjPxaetJELjMeBfQd05ISAtiDS0zbXs9f+idIjlh3OGMXPWGpDNDBytT\n" +
                "aUlZ7SqulSsof06zRis=", encryptedTxt);

    }


}
