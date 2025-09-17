package pages;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthorizedPage {

    private Response response;

    public void acessarAuthorized(String userName) {
        String password = "Senh@363";
        System.out.println("usuario  " + userName);
        String body = String.format("{ \"userName\": \"%s\", \"password\": \"%s\" }", userName, password);
        this.response = RestAssured
                .given()
                .baseUri("https://demoqa.com")
                .basePath("/Account/v1/Authorized")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post();
    }

    public int obterStatus() {
        return response.getStatusCode();
    }

    public Response getResponse() {
        return response;
    }
}