package steps;


import io.cucumber.java.pt.*;
import org.junit.Assert;
import pages.AcessarLivros;


public class LivrosSteps {

    AcessarLivros livrosPage = new AcessarLivros();

    @Dado("que eu acesso a API de livros")
    public void acessarApiDeLivros() {
        livrosPage.acessarLivros();
    }

    @Quando("eu realizo a consulta")
    public void realizarConsulta() {
        int statusCode = livrosPage.getResponse().getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Entao("a resposta deve conter a lista de livros")
    public void verificarListaDeLivros() {
        System.out.println("fim da lista de livros");
        boolean livrosPresentes = livrosPage.listaDeLivrosExiste();
        Assert.assertTrue("A lista de livros está vazia ou não foi retornada.", livrosPresentes);


    }
}