package br.com.alura.leilao;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected ChromeDriver browser;

    public PageObject(ChromeDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (browser == null){
            this.browser = new ChromeDriver();
        }
        else {
            this.browser = browser;
        }

        this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void fechar() {
        this.browser.quit();
    }

    public ChromeDriver getBrowser() {
        return browser;
    }

    public void setBrowser(ChromeDriver browser) {
        this.browser = browser;
    }
}
