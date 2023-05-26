import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una dirección IP: ");
        String ipAddress = scanner.nextLine();

        if (isValidIPAddress(ipAddress)) {
            System.out.println(ipAddress + " es una dirección IP válida.");
        } else {
            System.out.println(ipAddress + " no es una dirección IP válida.");
        }
    }

    public static boolean isValidIPAddress(String ipAddress) {
        String pattern = "^(?:\\d{1,3}\\.){3}\\d{1,3}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(ipAddress);

        return matcher.matches();
    }
}
