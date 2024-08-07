import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PinGenerator {

    // List of common date formats
    private static final String[] BIRTHDAY_FORMATS = {"ddMMyy", "MMddyy", "yyMMdd", "ddMMyyyy", "MMddyyyy", "yyyyMMdd"};

    // Method to generate a random 6-digit PIN with specific rules and hash it
    public static String generateAndHashPin(String birthday) {
        String pin = generatePin(birthday);
        return hashPin(pin);
    }

    // Method to generate a random 6-digit PIN with specific rules
    private static String generatePin(String birthday) {
        Random random = new Random();
        List<String> invalidPins = getInvalidPins(birthday);

        while (true) {
            String pin = String.format("%06d", random.nextInt(1000000)); // Generate random 6-digit number

            System.out.println(pin);
            if (!invalidPins.contains(pin) && !isSequential(pin)) { // Check if pin is valid
                return pin;
            }
        }
    }

    // Method to hash the PIN using SHA-256
    private static String hashPin(String pin) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(pin.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to check if a pin is sequential or its reverse
    private static boolean isSequential(String pin) {
        return isSequential(pin, 1) || isSequential(pin, -1);
    }

    private static boolean isSequential(String pin, int step) {
        for (int i = 0; i < pin.length() - 1; i++) {
            if (pin.charAt(i) + step != pin.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Method to get a list of invalid pins based on birthday formats
    private static List<String> getInvalidPins(String birthday) {
        List<String> invalidPins = new ArrayList<>();
        for (String format : BIRTHDAY_FORMATS) {
            invalidPins.add(format); // Add original format
            invalidPins.add(reverse(format)); // Add reverse format
            invalidPins.add(getFormattedBirthday(birthday, format)); // Add birthday format
        }
        return invalidPins;
    }

    // Method to reverse a string
    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method to format the birthday according to the specified format
    private static String getFormattedBirthday(String birthday, String format) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat(format);
        try {
            Date date = inputFormat.parse(birthday);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        // Sample birthday value
        String birthday = "25/04/1990";

        //String birthday = "123456";

        // Generate, hash, and print a valid PIN
        String hashedPin = generateAndHashPin(birthday);
        System.out.println("Generated and Hashed PIN: " + hashedPin);
    }
}
