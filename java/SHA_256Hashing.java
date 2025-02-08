import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256Hashing {
    /**
     * Computes the SHA-256 hash (digest) of the specified byte array.
     *
     * <p>This method obtains a {@code MessageDigest} instance for the SHA-256 algorithm,
     * updates the digest with the provided input bytes, and then completes the digest computation.
     *
     * @param bytes the input data to be hashed
     * @return a byte array containing the SHA-256 hash of the input data
     * @throws NoSuchAlgorithmException if the SHA-256 algorithm is not available on the platform
     *
     * @see <a href="https://www.baeldung.com/sha-256-hashing-java"> reference</a>
     */
    public static byte[] computeSha256(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(bytes);
    }
}
