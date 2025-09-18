package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DriverFactory;
import pages.FormularioPage;


public class FormularioSteps {

    WebDriver driver = DriverFactory.getDriver();
    FormularioPage formularioPage = new FormularioPage(driver);

    @Dado("que estou na página Practice Form")
    public void acessarPaginaPracticeForm() {
        driver.get("https://demoqa.com/");
    }

    @Quando("preencho todos os campos com dados válidos")
    public void preencherCamposComDadosValidos() {
        formularioPage.preencherFormulario();
    }

    @E("faço upload de um arquivo .txt")
    public void fazerUploadDoArquivoTxt() {
        formularioPage.uploadArquivoTxt();
    }

    @E("submeto o formulário")
    public void submeterFormulario() {
        formularioPage.clicarEmSubmit();
    }

    @Entao("o popup de confirmação deve ser exibido")
    public void verificarPopupDeConfirmacao() {
        Assert.assertTrue(formularioPage.popupFoiExibido());
    }

    @E("fecho o popup")
    public void fecharPopup() {
        formularioPage.fecharPopup();

    }



}