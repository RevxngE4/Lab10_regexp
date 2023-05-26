import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGBColorIdentifier {
    private static Map<String, String> colorNombres;

    static {
        colorNombres = new HashMap<>();
        colorNombres.put("#FFFFFF", "Blanco");
        colorNombres.put("#000000", "Negro");
        colorNombres.put("#FF0000", "Rojo");
        colorNombres.put("#FF3421","Rojo");
        colorNombres.put("#00ff00","Verde");
        colorNombres.put("232323", "Negro");
        colorNombres.put("#fd2","Azul");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un color en formato RGB (ejemplo: #FFFFFF): ");
        String color = scanner.nextLine();

        if (esColorRGB(color)) {
            System.out.println(color + " es un color RGB válido.");

            String nombreColor = obtenerNombreColor(color);
            if (nombreColor != null) {
                System.out.println("El color es: " + nombreColor);
            } else {
                System.out.println("No se encontró un nombre para el color.");
            }
        } else {
            System.out.println(color + " no es un color RGB válido.");
        }
    }

    public static boolean esColorRGB(String color) {
        String patron = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(color);

        return matcher.matches();
    }

    public static String obtenerNombreColor(String color) {
        return colorNombres.get(color);
    }
}

