package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.EntregaModel;

import static io.restassured.RestAssured.given;

public class CadastroEntregasService {
    EntregaModel entregaModel = new EntregaModel();
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public Response response;
    String baseUrl = "http://localhost:8081";

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "numeroPedido" -> entregaModel.setNumeroPedido(Integer.parseInt(value));
            case "nomeEntregador" -> entregaModel.setNomeEntregador(value);
            case "statusEntrega" -> entregaModel.setStatusEntrega(value);
            case "dataEntrega" -> entregaModel.setDataEntrega(value);
            default -> throw new IllegalArgumentException("Unexpected field: " + field);
        }
    }

    public void createDelivery(String endpoint) {
        String url = baseUrl + endpoint;
        String body = gson.toJson(entregaModel);

        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .extract().response();

    }

}
