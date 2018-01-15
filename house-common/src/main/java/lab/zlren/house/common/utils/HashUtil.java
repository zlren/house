package lab.zlren.house.common.utils;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * md5加盐加密
 *
 * @author zlren
 * @date 2018-01-15
 */
public class HashUtil {

    private static final HashFunction FUNCTION = Hashing.md5();

    private static final String SALT = "zlren";

    public static String encryPassword(String password) {
        HashCode hashCode = FUNCTION.hashString(password + SALT, Charset.forName("UTF-8"));
        return hashCode.toString();
    }
}
