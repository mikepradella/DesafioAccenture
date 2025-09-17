package steps;


import io.cucumber.java.pt.*;
import pages.CriarUsuario;
import static org.junit.Assert.*;

public class UsuarioSteps {
    CriarUsuario api = new CriarUsuario();

    @Dado("que eu acesso a API de usuários")
    public void acessarAPI() {

        api.acessarAPI();
    }


     @Quando("eu consulto o username")
    public void eu_consulto_o_username() {
     String name =  api.obterUsernameDoUsuario();
     assertNotNull(name);
    }

    @Então("o status deve ser {int}")
    public void o_status_deve_ser(Integer int1) {
      assertEquals(201,api.obterStatusCode());
    }


}