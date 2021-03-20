package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PaginaCadastro {

	private static WebDriver driver;

	private By nomeCadastro = By.name("usernameRegisterPage");

	private By emailCadastro = By.name("emailRegisterPage");

	private By senhaCadastro = By.name("passwordRegisterPage");

	private By confirmaSenhaCadastro = By.name("confirm_passwordRegisterPage");

	private By botaoCheck = By.cssSelector("input[name=i_agree]");

	private By botaoRegistrar = By.cssSelector("#register_btnundefined");

	private By alertaCadastro = By.cssSelector("label.invalid");

	public PaginaCadastro(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherNome(String nome) {
		driver.findElement(nomeCadastro).sendKeys(nome);
	}

	public void preencherEmail(String email) {
		driver.findElement(emailCadastro).sendKeys(email);
	}

	public void preencherSenha(String senha) {
		driver.findElement(senhaCadastro).sendKeys(senha);
	}

	public void preencherConfirmaSenha(String senha_confirmacao) {
		driver.findElement(confirmaSenhaCadastro).sendKeys(senha_confirmacao);
	}

	public void clicarCheckBox() {
		driver.findElement(botaoCheck).click();
	}

	public void clicarBotaoRegistrar() {
		driver.findElement(botaoRegistrar).click();
	}

	public boolean mensagemAlerta(String menssagem) {
		return menssagem.contentEquals(driver.findElement(alertaCadastro).getText());
	}

	public void clicarConfirmaSenha() {
		driver.findElement(confirmaSenhaCadastro).sendKeys(Keys.TAB);
	}

	public void clicarSenha() {
		driver.findElement(senhaCadastro).sendKeys(Keys.TAB);
	}

	public void clicarNome() {
		driver.findElement(nomeCadastro).sendKeys(Keys.TAB);
	}

	public void clicarEmail() {
		driver.findElement(emailCadastro).sendKeys(Keys.TAB);
	}
}
