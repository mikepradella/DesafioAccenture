package steps;

import io.cucumber.java.pt.*;
import pages.CriarUsuario;
import pages.GerarToken;

import static org.junit.Assert.*;

public class GerarTokenSteps {

    GerarToken gerarToken = new GerarToken();
    CriarUsuario api = new CriarUsuario();

    @Dado("que eu acesso a API de gerar token")
    public void que_eu_acesso_a_api_de_gerar_token() {

        gerarToken.acessarAPI(api.obterUsername());
    }
    @Quando("eu consulto o token gerado")
    public void eu_consulto_o_token_gerado() {
        String token= gerarToken.obterToken();
        System.out.println(" token -gerado  " + token);

    }
    @Então("o status devera ser {int}")
    public void o_status_devera_ser(Integer int1) {
        gerarToken.obterStatusCode();

    }

}
