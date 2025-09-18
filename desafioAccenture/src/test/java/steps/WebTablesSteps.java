package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DriverFactory;
import pages.WebTablesPage;

import java.util.Map;

public class WebTablesSteps {

    WebDriver driver = DriverFactory.getDriver();
    WebTablesPage webTablesPage = new WebTablesPage(driver);

    @Dado("que estou na página Web Tables")
    public void acessarPaginaWebTables() {
        driver.get("https://demoqa.com/webtables");
    }

    @Quando("eu clico no botão Add")
    public void clicarBotaoAdd() {
        webTablesPage.clicarBotaoAdd();
    }

    @E("preencho o formulário com os dados:")
    public void preencherFormulario(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dados = dataTable.asMaps().get(0);
        webTablesPage.preencherFormulario(
                dados.get("First Name"),
                dados.get("Last Name"),
                dados.get("Email"),
                dados.get("Age"),
                dados.get("Salary"),
                dados.get("Department")
        );
    }

    @E("clico em Submit")
    public void clicarSubmit() {
        webTablesPage.clicarSubmit();
    }

    @Então("o registro {string} deve aparecer na tabela")
    public void verificarRegistro(String nomeCompleto) {
        boolean existe = webTablesPage.verificarRegistroNaTabela(nomeCompleto);
        Assert.assertTrue("❌ Registro não encontrado: " + nomeCompleto, existe);
    }

    @Quando("eu edito o registro {string} para o departamento {string}")
    public void editarRegistro(String nomeCompleto, String novoDepartamento) {
        webTablesPage.editarRegistro(nomeCompleto, novoDepartamento);
    }

    @Então("o registro {string} deve conter o departamento {string}")
    public void verificarDepartamento(String nomeCompleto, String departamentoEsperado) {
        boolean ok = webTablesPage.verificarDepartamento(nomeCompleto, departamentoEsperado);
        Assert.assertTrue("❌ Departamento não atualizado corretamente", ok);
    }

    @Quando("eu deleto o registro {string}")
    public void deletarRegistro(String nomeCompleto) {
        webTablesPage.deletarRegistro(nomeCompleto);
    }

    @Então("o registro {string} não deve mais estar na tabela")
    public void verificarRemocao(String nomeCompleto) {
        boolean removido = webTablesPage.registroFoiRemovido(nomeCompleto);
        Assert.assertTrue("❌ Registro ainda está na tabela", removido);
    }
}