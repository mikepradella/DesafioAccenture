package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.ScrollUtils.scrollToElement;

public class FormularioPage {

    WebDriver driver;


    @FindBy(xpath = "//h5[text()='Forms']")
    WebElement entrarformulario;

    @FindBy(xpath = "//span[contains(text(),'Practice Form')]") WebElement entrarMenu;
    @FindBy(id = "firstName") WebElement campoNome;
    @FindBy(id = "lastName") WebElement campoSobrenome;
    @FindBy(id = "userEmail") WebElement campoEmail;
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label") WebElement radioMasculino;
    @FindBy(id = "userNumber") WebElement campoCelular;
    @FindBy(id = "uploadPicture") WebElement campoUpload;
    @FindBy(id = "submit") WebElement botaoSubmit;
    @FindBy(id = "example-modal-sizes-title-lg") WebElement tituloPopup;
    @FindBy(id = "closeLargeModal") WebElement botaoFecharPopup;

    public FormularioPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void preencherFormulario() {
        scrollToElement(driver,entrarformulario);
        entrarformulario.click();
        scrollToElement(driver,entrarMenu);
        entrarMenu.click();
        campoNome.sendKeys("mike tyson");
        campoSobrenome.sendKeys("pradella");
        campoEmail.sendKeys("mike.pradella@example.com");
        radioMasculino.click();
        campoCelular.sendKeys("11999999999");
    }

    public void uploadArquivoTxt() {
        String caminhoArquivo = System.getProperty("user.dir") + "/src/test/resources/arquivo.txt";
        campoUpload.sendKeys(caminhoArquivo);
    }

    public void clicarEmSubmit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoSubmit);
    }

    public boolean popupFoiExibido() {
        return tituloPopup.isDisplayed();
    }

    public void fecharPopup() {
        scrollToElement(driver,botaoFecharPopup);
        //Isso ignora interferências visuais e força o clique diretamente no DOM.
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoFecharPopup);
        botaoFecharPopup.click();
    }
}