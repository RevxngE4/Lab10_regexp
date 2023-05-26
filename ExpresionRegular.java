import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionRegular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa una cadena: ");
        String cadena = scanner.nextLine();

        String expresionRegular = ".*abcd2023111111102023.*";
        Pattern pattern = Pattern.compile(expresionRegular);

        Matcher matcher = pattern.matcher(cadena);

        if (matcher.matches()) {
            String resultado = cadena.replaceAll("2023", "feliz año nuevo");
            System.out.println("Cadena resultante: " + resultado);
        } else {
            System.out.println("La cadena no cumple con el patrón especificado.");
        }
    }
}
