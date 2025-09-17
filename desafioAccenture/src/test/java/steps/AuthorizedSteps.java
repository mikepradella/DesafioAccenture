package steps;


import io.cucumber.java.pt.*;
import org.junit.Assert;
import pages.AuthorizedPage;
import pages.CriarUsuario;

public class AuthorizedSteps {

    AuthorizedPage authorizedPage = new AuthorizedPage();
    CriarUsuario api = new CriarUsuario();

    @Dado("que eu acesso a API de Authorized")
    public void acessarApiAuthorized() {
        authorizedPage.acessarAuthorized(api.obterUsername());
    }

    @Quando("eu consulto o com sucesso")
    public void consultarComSucesso() {
        int statusCode = authorizedPage.getResponse().getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Entao("o status devera ser true")
    public void statusDeveSerTrue() {
        authorizedPage.getResponse().body().prettyPrint();
    }
}