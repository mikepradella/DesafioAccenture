package steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.AcessarLivros;
import pages.AdicionarLivroPage;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class AdicionarLivroSteps {

    private final AdicionarLivroPage livroPage = new AdicionarLivroPage();
    private String userId = "23ede019-8153-445f-94c2-9f79e0e4d4ee";
    private String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1pa2U3IiwicGFzc3dvcmQiOiJTZW5oQDM2MyIsImlhdCI6MTc1ODEzMTIyNX0.5rZp1iV6hC-RR4ZimvlOmk-rxndLq8XX8_IFNonzdtw";
    private String isbnSelecionado;

    @Dado("que eu tenho um usuário autorizado")
    public void usuarioAutorizado() {
        AcessarLivros acessarLivros = new AcessarLivros();
        acessarLivros.acessarLivros();

        Response resp = acessarLivros.getResponse();
        if (resp == null || resp.getStatusCode() != 200) {
            throw new RuntimeException("❌ Falha ao acessar livros. Status: " + (resp != null ? resp.getStatusCode() : "null"));
        }

        List<Map<String, Object>> livros = resp.jsonPath().getList("books");
        if (livros == null || livros.isEmpty()) {
            throw new RuntimeException("❌ Nenhum livro encontrado na resposta.");
        }

        int indice = new Random().nextInt(livros.size());
        Object isbnObj = livros.get(indice).get("isbn");

        if (isbnObj == null) {
            throw new RuntimeException("❌ ISBN está nulo no índice " + indice);
        }

        isbnSelecionado = isbnObj.toString();
        System.out.println("✅ ISBN selecionado: " + isbnSelecionado);
    }

    @Quando("eu adiciono o livro com ISBN")
    public void euAdicionoOLivroComISBN() {
        if (isbnSelecionado == null || isbnSelecionado.isEmpty()) {
            throw new RuntimeException("❌ ISBN não foi definido antes da adição.");
        }

        livroPage.adicionarLivro(userId, token, isbnSelecionado);
    }

    @Entao("o status da resposta deve ser {int}")
    public void verificarStatus(int statusEsperado) {
        int statusCode = livroPage.obterStatusCode();
        Assert.assertEquals("❌ Status inesperado", statusEsperado, statusCode);
        System.out.println("✅ Livro adicionado com sucesso! Status: " + statusCode);
    }
}