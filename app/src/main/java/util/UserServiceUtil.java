package util;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {
    public static boolean checkPassword(String plainText,String hashText)
    {
       return  BCrypt.checkpw(plainText,hashText);
    }
    public static String hashPassword(String plainText) {
            return BCrypt.hashpw(plainText,BCrypt.gensalt());
    }
}
