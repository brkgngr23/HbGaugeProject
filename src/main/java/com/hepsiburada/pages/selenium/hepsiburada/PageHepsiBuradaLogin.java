package com.hepsiburada.pages.selenium.hepsiburada;

import java.util.List;

import com.hepsiburada.basepage.AbstractBase;
import com.hepsiburada.basepage.SeleniumAbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.hepsiburada.base.SeleniumAbstractTest;
import com.hepsiburada.data.GetData;
import com.thoughtworks.gauge.Step;



public class PageHepsiBuradaLogin extends SeleniumAbstractTest {

	SeleniumAbstractPage lib= new SeleniumAbstractPage();

	private final WebDriver driver;
	public PageHepsiBuradaLogin () {
		this.driver= SeleniumAbstractTest.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (how =How.XPATH, using ="//div[@id='myAccount']")
	WebElement btnGiris;
	@FindBy (how =How.XPATH, using ="//a[@id='login']")
	WebElement btnLogin;
	@FindBy (how =How.XPATH, using ="//span[@class='_17OD2T5uhxYRT6atZy_yA7 hpa5gnmuOMPuH0E31USHp']")
	List <WebElement> cntrlGirisSayfa;
	@FindBy (how =How.XPATH, using ="//input[@id='txtUserName']")
	WebElement txtUserName;
	@FindBy (how =How.XPATH, using ="//input[@id='txtPassword']")
	WebElement txtPassword;
	@FindBy (how =How.XPATH, using ="//button[@id='btnLogin']")
	WebElement btnLoginGirisi;
	@FindBy (how =How.XPATH, using ="//input[@placeholder='Ürün, kategori veya marka ara']")
	List <WebElement> cntrlAnaSayfa;
	
	
	@Step({"Anasayfa kontrolu ve login olma"})
	public PageHepsiBuradaAnaSayfa login () throws InterruptedException {
		lib.navigateTo(GetData.url);
		lib.Control(btnGiris.isDisplayed(),"Anasayfanın geldigi gorulur","Anasayfa gorunur olmadi");
		girisYap();
		return new PageHepsiBuradaAnaSayfa();
	}
	
	public PageHepsiBuradaLogin girisYap() throws InterruptedException {
		btnGiris.click();
		Thread.sleep(1000);
		btnLogin.click();
		Thread.sleep(3000);
		txtUserName.sendKeys("testhepsiburada23@gmail.com");
		Thread.sleep(1000);
		txtPassword.sendKeys("Test.123456789");
		Thread.sleep(1000);
		btnLoginGirisi.click();
		
		return this;
		
	}
}