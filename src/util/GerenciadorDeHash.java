package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * <p> Possui alguns metodos para operacoes de hashing. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 1.0.1
 */
public class GerenciadorDeHash {

    private final Logger logger = Logger.getGlobal();

    /**
     * <p> Calcula o hash MD5 da string fornecida. </p>
     *
     * @param string Sera usada para obeter o hash MD5.
     *
     * @return Hash MD5 pronto para ser usado.
     */
    public String md5(String string) {
        if (string == null || string.isEmpty()) {
            logger.severe("A string nao e valida.");
            return "";
        }

        try {
            MessageDigest digest  = MessageDigest.getInstance("MD5");
            byte[]        bytes   = digest.digest(string.getBytes());
            StringBuilder builder = new StringBuilder();

            for (byte b : bytes) {
                builder.append(String.format("%02x", b));
            }

            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}