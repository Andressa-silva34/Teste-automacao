package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PaginaLogin {

	private static WebDriver driver;

	private By nomeU = By.name("username");
	private By senhaU = By.name("password");
	private By botaoEntrar = By.id("sign_in_btnundefined");
	private By alerta = By.cssSelector("label.invalid");
	private By criarConta = By.cssSelector("a[class=\"select ng-scope\"]");

	private By botaoCadastro = By.cssSelector("a[class=\"create-new-account ng-scope\"]");
			
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
	}

	public PaginaCadastro clicarCadastro() {
		driver.findElement(botaoCadastro).click();
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(java.lang.NullPointerException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(criarConta));
		
		
		return new PaginaCadastro(driver);
	}

	public void preencherNome(String nome) {
		driver.findElement(nomeU).sendKeys(nome);
	}

	public void preencherSenha(String senha) {
		driver.findElement(senhaU).sendKeys(senha);
	}

	public void clicarBotaoEntrar() {
		driver.findElement(botaoEntrar).click();

	}

	public boolean mensagemAlerta(String menssagem) {
		return menssagem.contentEquals(driver.findElement(alerta).getText());
	}

	public void clicarSenha() {
		driver.findElement(senhaU).sendKeys(Keys.TAB);
	}

}
