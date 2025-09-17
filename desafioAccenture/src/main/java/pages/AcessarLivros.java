package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AcessarLivros {

    private Response response;

    public void acessarLivros() {
       this.response = RestAssured
                .given()
                .baseUri("https://demoqa.com")
                .basePath("/BookStore/v1/Books")
                .header("accept", "application/json")
                .when()
                .get();
        // Exibe a resposta completa
        this.response.prettyPrint();

        if (this.response == null) {
            System.out.println("⚠️ A resposta está nula!");
        } else {
            System.out.println("✅ Status da resposta: " + this.response.getStatusCode());
            this.response.prettyPrint();
        }

    }

    public Response getResponse() {
        return this.response;
    }

    public boolean listaDeLivrosExiste() {
        return this.response.jsonPath().getList("books").size() > 0;
    }
}