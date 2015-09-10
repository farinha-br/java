import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.math.BigInteger;  

public class Decryption {

    public static String decrypt(String encrypted, String pswd) {
		
         try {
			 
			 String rnd = encrypted.substring(0,24);
			 
             byte[] encted = toByteArray(encrypted.substring(24));
			 
			 String key = rnd+pswd;
			 key = MD5(key).substring(16);
             
             Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
             Cipher cipher = Cipher.getInstance("AES");

			 cipher.init(Cipher.DECRYPT_MODE, aesKey);
			 String decrypted = new String(cipher.doFinal(encted));
			 return(decrypted.substring(24));
		 
      }catch(Exception e) {
         e.printStackTrace();
      }
	  return "";
    }
	
	public static String rndString() {
			SecureRandom random = new SecureRandom();
			return (new BigInteger(128, random).toString(32).substring(0,24));
    }

	public static String toHexString(byte[] array) {
	    return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
    	return DatatypeConverter.parseHexBinary(s);
    }

    public static String MD5(String md5) {
     	  try {
        	java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
        	   sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	        }
          	return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
   }

}