package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.ScrollUtils.scrollToElement;

public class BrowserWindowsPage {
     WebDriver driver;

    @FindBy(id = "windowButton") WebElement btnNewWindow;
    @FindBy(tagName = "h1") WebElement sampleText;


    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ← ESSENCIAL
    }

    public void clicarBotaoNovaJanela() {
        scrollToElement(driver,btnNewWindow);
        btnNewWindow.click();
    }

    public String obterTextoDaNovaJanela() {
        scrollToElement(driver,sampleText);
        return sampleText.getText();
    }
}