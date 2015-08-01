package co.com.gaslissa.core.usuario.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
	
	private static final String SHA_1 = "SHA-1";

	
	public static String createHash(String unhasehd){
		byte[] digest = null;
        byte[] buffer = unhasehd.getBytes();
        String hash = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_1);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
            for(byte aux : digest) {
                int b = aux & 0xff;
                if (Integer.toHexString(b).length() == 1) hash += "0";
                hash += Integer.toHexString(b);
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return hash;
	}

}
