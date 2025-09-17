package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Random;


public class CriarUsuario {

    private Response response;


    public void acessarAPI() {
        System.out.println("este usuario que cadastrei" + ContextoCompartilhado.userName);
        response = RestAssured
                .given()
                .baseUri("https://demoqa.com")
                .basePath("/Account/v1/User")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{ \"userName\": \""+ContextoCompartilhado.userName+"\", \"password\": \"Senh@363\" }")
                .when()
                .post();

        // Exibe a resposta no console
        response.prettyPrint();

    }

     public String obterUsernameDoUsuario() {
        return response.jsonPath().getString("username");
    }
    public String obterUsername() {
        return ContextoCompartilhado.userName; // já é o mesmo que foi enviado na requisição
    }

    public int obterStatusCode() {
        return response.getStatusCode();
    }
}