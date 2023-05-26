import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumberFromFile {
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

            List<Integer> numerosEnteros = extraerNumerosEnteros(contenidoTexto);
            mostrarNumerosSeparadosPorComas(numerosEnteros);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> extraerNumerosEnteros(String texto) {
        List<Integer> numerosEnteros = new ArrayList<>();
        Pattern patron = Pattern.compile("\\d+");
        Matcher matcher = patron.matcher(texto);

        while (matcher.find()) {
            int numero = Integer.parseInt(matcher.group());
            numerosEnteros.add(numero);
        }

        return numerosEnteros;
    }

    public static void mostrarNumerosSeparadosPorComas(List<Integer> numeros) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numeros.size(); i++) {
            sb.append(numeros.get(i));

            if (i < numeros.size() - 1) {
                sb.append(",");
            }
        }

        System.out.println(sb.toString());
    }
}
