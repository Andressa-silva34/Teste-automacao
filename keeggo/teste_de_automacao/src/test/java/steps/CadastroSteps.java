package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.PaginaCadastro;
import pages.PaginaInicial;
import pages.PaginaLogin;

public class CadastroSteps {

	private static WebDriver driver;
	private PaginaInicial paginaInicial = new PaginaInicial(driver);
	private PaginaLogin paginaLogin = new PaginaLogin(driver);
	private PaginaCadastro paginaCadastro = new PaginaCadastro(driver);
	private HomePage homePage = new HomePage(driver);

	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\87\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Dado("que acesso a tela de cadastro")
	public void que_acesso_a_tela_de_cadastro() {
		paginaInicial.carregarPagina();
		assertThat(paginaInicial.obterTituloDaPagina(), is(" Advantage Shopping"));
		paginaInicial.clicarBotaoSignIn();
		paginaLogin.clicarCadastro();

	}

	@Quando("submeto o meu cadastro com nome: {string}, email: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_nome_email_senha_e_senha_de_confirmacao(String nome, String email,
			String senha, String senha_confirmacao) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.preencherEmail(email);
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

		paginaCadastro.clicarCheckBox();

		paginaCadastro.clicarBotaoRegistrar();

	}

	@Então("devo ser redirecionado pagina incial")
	public void devo_ser_redirecionado_pagina_incial() {
		assertThat(homePage.paginaLogadaSucesso("andressa"), is(true));
	}

	@Quando("submeto o meu cadastro com email: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_email_senha_e_senha_de_confirmacao(String email, String senha,
			String senha_confirmacao) {
		paginaCadastro.clicarNome();
		paginaCadastro.preencherEmail(email);
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

	}

	@Quando("submeto o meu cadastro com nome: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_nome_senha_e_senha_de_confirmacao(String nome, String senha,
			String senha_confirmacao) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.clicarEmail();
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);

	}

	@Quando("submeto o meu cadastro com nome: {string} e email: {string}")
	public void submeto_o_meu_cadastro_com_nome_e_email(String nome, String email) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.preencherEmail(email);
		paginaCadastro.clicarSenha();
		paginaCadastro.clicarConfirmaSenha();

	}

	@Quando("submeto o meu cadastro com submeto o meu cadastro com nome: {string}, email: {string}, senha: {string} e senha de confirmacao: {string}")
	public void submeto_o_meu_cadastro_com_submeto_o_meu_cadastro_com_nome_email_senha_e_senha_de_confirmacao(
			String nome, String email, String senha, String senha_confirmacao) {

		paginaCadastro.preencherNome(nome);
		paginaCadastro.preencherEmail(email);
		paginaCadastro.preencherSenha(senha);
		paginaCadastro.preencherConfirmaSenha(senha_confirmacao);
		
		paginaCadastro.clicarConfirmaSenha();

	}

	@Então("devo ver a mensagem {string}")
	public void devo_ver_a_mensagem(String mensagem_saida) {

		assertThat(paginaCadastro.mensagemAlerta(mensagem_saida), is(true));
	}

	@After(order = 1)
	public void capturaTela(Scenario scenario) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);

		String nomeArquivo = "resources/screenshots/" + scenario.getName() + "_" + scenario.getStatus() + ".png";
		System.out.println(nomeArquivo);
		try {
			Files.move(capturaDeTela, new File(nomeArquivo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After(order = 0)
	public static void fecharPagina() {
		driver.quit();
	}
}
