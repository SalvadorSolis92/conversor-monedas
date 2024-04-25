package controller;

import com.google.gson.Gson;
import model.ResponseExchangeRatePair;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Esta clase será el cliente que sabe comunicarse con la API
 */
public class RestControllesExchangeRate {

    private String uri;
    private String key;
    private String metodoInvocado;
    private URI direccion;

    /**
     * El constructir inicializa la URL del enpoint de la APU
     */
    public RestControllesExchangeRate(){
        this.uri = "https://v6.exchangerate-api.com/v6/";
        this.key = "31507e04061dd8cf5d495fdf";
        this.metodoInvocado = "/pair/";
    }

    /**
     * Este método obtiene el tipo de cambio recibiendo el tipo de monedas de conversión
     * @param monedaBase código de moneda base de tres letras ISO 4217
     * @param monedaDestino código de moneda destino de tres letras ISO 4217
     * @param cantidad cantidad a convertir en formato xxxx.xxxx
     */
    public void convertirDivisa(String monedaBase, String monedaDestino, Double cantidad){
        this.direccion = URI.create(this.uri + this.key + this.metodoInvocado+monedaBase +"/" + monedaDestino + "/" + cantidad);
        ResponseExchangeRatePair responseEx = null;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            responseEx = new Gson().fromJson(response.body(), ResponseExchangeRatePair.class);
            imprimeRespuesta(responseEx, cantidad);
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
    }

    private void imprimeRespuesta(ResponseExchangeRatePair responseEx, Double cantidad){
        if (responseEx.result().equals("success")){
            System.out.println("El valor de " + cantidad + " " + responseEx.base_code() + " en " + responseEx.target_code() + " es de => " + responseEx.conversion_result() + " " + responseEx.target_code());
        }else{
            System.err.println("Error en la comunicación con la API, intentalo mas tarde.");
        }
    }
}
