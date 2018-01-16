package lab.zlren.house.web.interceptor;

import lab.zlren.house.common.entity.User;

/**
 * @author zlren
 * @date 2018-01-16
 */
public class UserContext {

    private static final ThreadLocal<User> USER_HODLER = new ThreadLocal<>();

    public static void setUser(User user) {
        USER_HODLER.set(user);
    }

    public static void remove() {
        USER_HODLER.remove();
    }

    public static User getUser() {
        return USER_HODLER.get();
    }
}
