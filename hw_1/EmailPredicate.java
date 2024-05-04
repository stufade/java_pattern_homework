package hw_1;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailPredicate implements Predicate<String> {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    @Override
    public boolean test(String s) {
        if (s == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(s).matches();
    }

    public static void main(String[] args) {
        EmailPredicate emailPredicate = new EmailPredicate();

        // Тестовые email-адреса
        String[] emails = { "example@example.com", "hello.world@domain.com", "invalid-email@",
                "another.invalid-.email@domain", "valid_email123@example.com.co" };
        for (String email : emails) {
            boolean isValid = emailPredicate.test(email);
            System.out.println("Email " + email + " is valid: " + isValid);
        }
    }
}
