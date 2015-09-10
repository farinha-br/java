import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.math.BigInteger;  

public class Encryption {

    public static String encrypt(String plain, String pswd) {
         try {
			 // add random string to begin of plaintext
			 String rnd = rndString();
             String text = rndString()+plain;
			 
			 // join random string and password
             String key = rnd+pswd;
			 // md5 key and select 16 chars
			 key = MD5(key).substring(16);

             Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
             Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			String enc =  new String(toHexString(encrypted));
			return(rnd+enc);

      }catch(Exception e) {
         e.printStackTrace();
      }
	  return "";
    }
	
	// random string 24 chars
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