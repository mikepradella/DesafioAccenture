package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage {

    private WebDriver driver;

    @FindBy(id = "startStopButton") WebElement btnStartStop;
    @FindBy(css = ".progress-bar") WebElement barraProgresso;
    @FindBy(id = "resetButton") WebElement btnReset;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clicarBotaoStartStop() {
        ScrollUtils.scrollToElement(driver,btnStartStop);
        btnStartStop.click();
    }

    public void clicarBotaoReset() {
        btnReset.click();
    }

    public int obterValorProgresso() {
        String texto = barraProgresso.getText().replace("%", "").trim();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void pararAntesDos25() {
        clicarBotaoStartStop(); // inicia

        int valor = 0;
        int tentativas = 0;

        while (tentativas < 30) {
            valor = obterValorProgresso();
            if (valor > 0) {
                clicarBotaoStartStop(); // pausa assim que começa
                break;
            }
            try {
                Thread.sleep(30); // checa a cada 30ms
            } catch (InterruptedException e) {
                break;
            }
            tentativas++;
        }
        clicarBotaoStartStop(); // pausa
    }

    public boolean aguardarProgressoCompleto() {
        int tentativas = 0;
        while (tentativas < 30) {
            int valor = obterValorProgresso();
            if (valor == 100) return true;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            tentativas++;
        }
        return false;
    }

    public boolean progressoMenorOuIgualA(int limite) {
        int valor = obterValorProgresso();
        System.out.println("📊 Valor atual da barra: " + valor + "%");
        return valor <= limite;
    }

    public boolean progressoFoiResetado() {
        int valor = obterValorProgresso();
        return valor == 0;
    }
}