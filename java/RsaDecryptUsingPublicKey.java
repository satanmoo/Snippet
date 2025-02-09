import javax.crypto.Cipher;
import java.security.PublicKey;

public class RsaDecryptUsingPublicKey {
    /**
     * RSA Decryption Using Public Key
     *
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html#doFinal-byte:A-">Cipher#doFinal</a>
     *
     * @param publicKey the RSA public key used for decryption
     * @param signature the RSA signature bytes to be decrypted
     * @return the decrypted byte array (typically the hash of the original message)
     * @throws RuntimeException if any cryptographic error occurs
     */
    public byte[] decrypt(final PublicKey publicKey, final byte[] signature) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return cipher.doFinal(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
