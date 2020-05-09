package aplicacion.clases;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {

    //////////////////////////////////////////////////
    //Atributos
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String SALT = "nv3M1mQEfzetQyuyRo3esELNu6KBHI";

    //////////////////////////////////////////////////
    //Métodos
    public static byte[] hash(char[] clave, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(clave, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(clave, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error intentando hacer hash: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String generarClaveSegura(String clave) {
        String returnValue = null;

        byte[] securePassword = hash(clave.toCharArray(), SALT.getBytes());

        returnValue = Base64.getEncoder().encodeToString(securePassword);

        return returnValue;
    }

    public static boolean verificarClave(String clave, String claveSegura) {
        //Generamos la clave con el salt
        String newSecurePassword = generarClaveSegura(clave);

        //Comprobamos si son iguales
        return newSecurePassword.equalsIgnoreCase(claveSegura);
    }
}
