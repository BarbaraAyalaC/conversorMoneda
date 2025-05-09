import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "fd2a8d99d988a717cffaf1e8";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getExchangeRate(String from, String to) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to;

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        con.disconnect();

        JSONObject obj = new JSONObject(response.toString());

        if (!obj.getString("result").equals("success")) {
            throw new RuntimeException("Error en la API: " + obj.toString());
        }

        return obj.getDouble("conversion_rate");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Moneda de origen (ej: USD): ");
        String from = scanner.nextLine().toUpperCase();

        System.out.print("Moneda de destino (ej: EUR): ");
        String to = scanner.nextLine().toUpperCase();

        System.out.print("Cantidad a convertir: ");
        double amount = scanner.nextDouble();

        try {
            double rate = getExchangeRate(from, to);
            double converted = amount * rate;

            System.out.printf("%.2f %s = %.2f %s%n", amount, from, converted, to);
        } catch (Exception e) {
            System.out.println("Error al obtener el tipo de cambio:");
        }
    }
}
