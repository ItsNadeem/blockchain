import com.google.gson.GsonBuilder;
import java.security.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class StringUtil {

    public static String applySHA256(String input) {
        try {
            //Applies sha256 to our input,
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            // This will contain hash as hexidecimal
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
