package steps;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DriverFactory;
import pages.ProgressBarPage;
import pages.ScrollUtils;

public class ProgressBarSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProgressBarPage progressPage = new ProgressBarPage(driver);

    @Dado("que estou na página Progress Bar")
    public void acessarPaginaProgressBar() {
        driver.get("https://demoqa.com/progress-bar");
    }

    @Quando("eu clico no botão Start")
    public void clicarBotaoStart() {

        progressPage.clicarBotaoStartStop();
    }

    @E("eu paro a barra de progresso antes de atingir 25%")
    public void pararAntesDos25() {
        progressPage.pararAntesDos25();
    }

    @Então("o valor da barra deve ser menor ou igual a 25%")
    public void validarValorMenorOuIgualA25() {
        boolean ok = progressPage.progressoMenorOuIgualA(25);
        Assert.assertTrue("❌ Valor da barra é maior que 25%", ok);
    }

    @Quando("eu clico no botão Start novamente")
    public void clicarBotaoStartNovamente() {
        progressPage.clicarBotaoStartStop();
    }

    @E("aguardo até que a barra atinja 100%")
    public void aguardarAte100() {
        boolean completo = progressPage.aguardarProgressoCompleto();
        Assert.assertTrue("❌ A barra não chegou a 100%", completo);
    }

    @Então("a barra deve ser resetada para 0%")
    public void validarReset() {
        progressPage.clicarBotaoReset();
        boolean resetado = progressPage.progressoFoiResetado();
        Assert.assertTrue("❌ A barra não foi resetada", resetado);
    }
}