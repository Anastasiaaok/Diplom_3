package utils;

public class UserGenerator {

    public static String generateEmail() {
        return "test" + System.currentTimeMillis() + "@mail.com";
    }

    public static String generatePassword() {
        return "123456";
    }

    public static String generateName() {
        return "TestUser";
    }
}
