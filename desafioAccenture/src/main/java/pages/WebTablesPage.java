package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static pages.ScrollUtils.scrollToElement;

public class WebTablesPage {

    private WebDriver driver;

    @FindBy(id = "addNewRecordButton") WebElement btnAdd;
    @FindBy(id = "firstName") WebElement inputFirstName;
    @FindBy(id = "lastName") WebElement inputLastName;
    @FindBy(id = "userEmail") WebElement inputEmail;
    @FindBy(id = "age") WebElement inputAge;
    @FindBy(id = "salary") WebElement inputSalary;
    @FindBy(id = "department") WebElement inputDepartment;
    @FindBy(id = "submit") WebElement btnSubmit;
    @FindBy(css = ".rt-tr-group") List<WebElement> registros;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clicarBotaoAdd() {
        scrollToElement(driver,btnAdd);
        btnAdd.click();
    }

    public void preencherFormulario(String nome, String sobrenome, String email, String idade, String salario, String departamento) {
        inputFirstName.clear(); inputFirstName.sendKeys(nome);
        inputLastName.clear(); inputLastName.sendKeys(sobrenome);
        inputEmail.clear(); inputEmail.sendKeys(email);
        inputAge.clear(); inputAge.sendKeys(idade);
        inputSalary.clear(); inputSalary.sendKeys(salario);
        inputDepartment.clear(); inputDepartment.sendKeys(departamento);
    }

    public void clicarSubmit() {
        btnSubmit.click();
    }

    public boolean verificarRegistroNaTabela(String nomeCompleto) {
        try {
            Thread.sleep(1000); // espera 1 segundo para o DOM atualizar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registros = driver.findElements(By.cssSelector(".rt-tr-group")); // força nova leitura
        return registros.stream().anyMatch(registro -> registro.getText().contains(nomeCompleto));
    }

    public void editarRegistro(String nomeCompleto, String novoDepartamento) {
        for (WebElement registro : registros) {
            if (registro.getText().contains(nomeCompleto)) {
                registro.findElement(By.cssSelector("span[title='Edit']")).click();
                inputDepartment.clear();
                inputDepartment.sendKeys(novoDepartamento);
                btnSubmit.click();
                break;
            }
        }
    }

    public boolean verificarDepartamento(String nomeCompleto, String departamentoEsperado) {
        for (WebElement registro : registros) {
            if (registro.getText().contains(nomeCompleto)) {
                return registro.getText().contains(departamentoEsperado);
            }
        }
        return false;
    }

    public void deletarRegistro(String nomeCompleto) {
        for (WebElement registro : registros) {
            if (registro.getText().contains(nomeCompleto)) {
                registro.findElement(By.cssSelector("span[title='Delete']")).click();
                break;
            }
        }
    }

    public boolean registroFoiRemovido(String nomeCompleto) {
        return registros.stream().noneMatch(registro -> registro.getText().contains(nomeCompleto));
    }
}