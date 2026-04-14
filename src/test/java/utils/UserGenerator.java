package utils;

import java.util.HashMap;
import java.util.Map;

public class UserGenerator {

    public static Map<String, String> generateUser() {
        Map<String, String> user = new HashMap<>();
        user.put("email", "test" + System.currentTimeMillis() + "@mail.com");
        user.put("password", "123456");
        user.put("name", "TestUser");
        return user;
    }
}