package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BrowserWindowsPage;
import pages.DriverFactory;

public class BrowserWindowsSteps {

    WebDriver driver = DriverFactory.getDriver();
    BrowserWindowsPage browserPage = new BrowserWindowsPage(driver);
    String janelaPrincipal;
    String novaJanela;

    @Dado("que estou na página Browser Windows")
    public void acessarPaginaBrowserWindows() {
        driver.get("https://demoqa.com/browser-windows");
        janelaPrincipal = driver.getWindowHandle();
    }

    @Quando("eu clico no botão {string}")
    public void clicarBotao(String botao) {
        browserPage.clicarBotaoNovaJanela();
    }

    @Então("uma nova janela deve ser aberta com a mensagem {string}")
    public void validarMensagemNovaJanela(String mensagemEsperada) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(janelaPrincipal)) {
                novaJanela = handle;
                driver.switchTo().window(novaJanela);
                break;
            }
        }

        String texto = browserPage.obterTextoDaNovaJanela();
        Assert.assertEquals(mensagemEsperada, texto);
    }

    @E("eu fecho a nova janela")
    public void fecharNovaJanela() {
        driver.close();
        driver.switchTo().window(janelaPrincipal);
        driver.quit();
    }
}