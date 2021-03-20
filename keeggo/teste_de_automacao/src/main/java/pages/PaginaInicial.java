package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicial {

		
	private static WebDriver driver;
	
	private By botaoSignIn = By.id("menuUser");
	
	
	public PaginaInicial(WebDriver driver) {
		this.driver = driver;
	}

	public void carregarPagina() {
		driver.get("https://advantageonlineshopping.com/#/");
		
	}

	public String obterTituloDaPagina() {
		return driver.getTitle();
	}

	public PaginaLogin clicarBotaoSignIn() {
		driver.findElement(botaoSignIn).click();
		return new PaginaLogin(driver);
	}
}
