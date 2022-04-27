package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.chrome.ChromeDriver;


public class CadastroLeilaoPage extends PageObject {

    private static final String URL_CADASTRO_LEILOES = "http://localhost:8081/leiloes/new";

    public CadastroLeilaoPage(ChromeDriver browser) {
        super(browser);
    }


    //preenche o formulario e submete
    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElementById("nome").sendKeys(nome);
        this.browser.findElementById("valorInicial").sendKeys(valorInicial);
        this.browser.findElementById("dataAbertura").sendKeys(dataAbertura);
        this.browser.findElementById("button-submit").submit();

        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILOES);
    }

    public boolean isMensagensDeValidacaoVisiveis() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }


}

