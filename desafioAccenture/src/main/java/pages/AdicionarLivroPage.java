package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdicionarLivroPage {

    private Response response;

    public void adicionarLivro(String userId, String token, String isbn) {

        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("❌ ISBN não pode ser nulo ou vazio.");
        }

        Map<String, Object> body = new HashMap<>();
        body.put("userId", userId);
        body.put("collectionOfIsbns", List.of(Map.of("isbn", isbn)));

        System.out.println(" isbn  ." + isbn);

        this.response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri("https://demoqa.com")
                .basePath("/BookStore/v1/Books")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post();

        // Exibe a resposta completa
        response.prettyPrint();
    }

    public int obterStatusCode() {
        return response.getStatusCode();
    }
}
