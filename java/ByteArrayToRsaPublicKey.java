import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class ByteArrayToRsaPublicKey {
    /**
     * Converts a byte array to an RSA public key.
     *
     * @param b the byte array representing the RSA public key in X.509 format
     * @return the RSA PublicKey object
     * @throws NoSuchAlgorithmException if RSA algorithm is not available
     * @throws InvalidKeySpecException if the key spec is invalid
     *
     * @see <a href="https://docs.oracle.com/javase/tutorial/security/apisign/vstep2.html">
     *      Input and Convert the Encoded Public Key Bytes Documentation</a>
     */
    public static PublicKey byteArrayToRsaPublicKey(byte[] b) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(b);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePublic(pubKeySpec);
    }
}
