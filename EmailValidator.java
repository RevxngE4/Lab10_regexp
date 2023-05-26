import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una dirección de correo electrónico: ");
        String email = scanner.nextLine();

        if (esEmailValido(email)) {
            System.out.println(email + " es una dirección de correo electrónico válida.");
        } else {
            System.out.println(email + " no es una dirección de correo electrónico válida.");
        }
    }

    public static boolean esEmailValido(String email) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}