import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDivisas {

    public Divisa compararDivisas(String codigoEntrada,String codigoSalida,double monto) {



        URI direccion = URI.create("https://v6.exchangerate-api.com/" +
                                   "v6/6eacebae4d6dfc72782f4423//pair/"+codigoEntrada+
                                   "/"+codigoSalida+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la conversion");
        }
    }
}
