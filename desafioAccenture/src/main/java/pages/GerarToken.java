package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Random;


public class GerarToken {
   private Response response;


    public void acessarAPI(String userName) {

        String password = "Senh@363";
        System.out.println("estou no gerar token - este usuario que cadastrei " + userName);
        String body = String.format("{ \"userName\": \"%s\", \"password\": \"%s\" }", userName, password);

         this.response = RestAssured
                .given()
                .baseUri("https://demoqa.com")
                .basePath("/Account/v1/GenerateToken")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post();

        // Exibe a resposta completa
        response.prettyPrint();
    }

     public String obterToken() {
         // Extrai o token, se existir
        return response.jsonPath().getString("token");
     }

    public int obterStatusCode() {
        return response.getStatusCode();
    }
}