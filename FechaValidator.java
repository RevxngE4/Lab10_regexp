import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FechaValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una fecha en el formato dd/mm/AAAA: ");
        String fecha = scanner.nextLine();

        if (esFechaValida(fecha)) {
            System.out.println(fecha + " es una fecha válida.");
        } else {
            System.out.println(fecha + " no es una fecha válida.");
        }
    }

    public static boolean esFechaValida(String fecha) {
        String patron = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([1-9]\\d{3}|[2-9]\\d{3})$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(fecha);

        if (matcher.matches()) {
            int dia = Integer.parseInt(matcher.group(1));
            int mes = Integer.parseInt(matcher.group(2));
            int anio = Integer.parseInt(matcher.group(3));

            if (mes == 2 && (dia > 29 || (dia == 29 && !esAnioBisiesto(anio)))) {
                return false;
            }

            return true;
        }

        return false;
    }

    public static boolean esAnioBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
}

