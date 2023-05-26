import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDecimalNumbers {
    public static void main(String[] args) {
        String filePath = "src\\selee.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            String contenidoTexto = sb.toString();

            List<Double> numerosDecimales = extraerNumerosDecimales(contenidoTexto);

            System.out.println("Matriz de números decimales:");
            double[][] matrizNumeros = construirMatrizNumeros(numerosDecimales);
            mostrarMatriz(matrizNumeros);

            double suma = calcularSuma(numerosDecimales);
            System.out.println("Suma de los números: " + suma);

            double maximo = encontrarMaximo(numerosDecimales);
            System.out.println("Número máximo: " + maximo);

            int numeroDeSerie = numerosDecimales.size();
            System.out.println("Número de serie del último número: " + numeroDeSerie);

            String resultadoCadena = reemplazarNumerosPorPalabra(contenidoTexto, "number");
            System.out.println("Cadena resultante: " + resultadoCadena);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Double> extraerNumerosDecimales(String texto) {
        List<Double> numerosDecimales = new ArrayList<>();
        Pattern patron = Pattern.compile("[-+]?\\d+(\\.\\d+)?");
        Matcher matcher = patron.matcher(texto);

        while (matcher.find()) {
            double numero = Double.parseDouble(matcher.group().replace(",", "."));
            numerosDecimales.add(numero);
        }

        return numerosDecimales;
    }

    public static double[][] construirMatrizNumeros(List<Double> numeros) {
        int filas = numeros.size();
        double[][] matriz = new double[filas][1];

        for (int i = 0; i < filas; i++) {
            matriz[i][0] = numeros.get(i);
        }

        return matriz;
    }

    public static void mostrarMatriz(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double calcularSuma(List<Double> numeros) {
        double suma = 0.0;

        for (double numero : numeros) {
            suma += numero;
        }

        return suma;
    }

    public static double encontrarMaximo(List<Double> numeros) {
        double maximo = Double.MIN_VALUE;

        for (double numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }

        return maximo;
    }

    public static String reemplazarNumerosPorPalabra(String texto, String palabra) {
        Pattern patron = Pattern.compile("[-+]?\\d+(\\.\\d+)?");
        Matcher matcher = patron.matcher(texto);
        return matcher.replaceAll(palabra);
    }
}
