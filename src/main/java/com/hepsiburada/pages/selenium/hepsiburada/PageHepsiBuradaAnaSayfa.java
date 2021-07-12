package com.hepsiburada.pages.selenium.hepsiburada;

import java.util.List;

import com.hepsiburada.base.SeleniumAbstractTest;
import com.hepsiburada.basepage.SeleniumAbstractPage;
import com.hepsiburada.utility.log;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.impl.Log4jLoggerAdapter;


public class PageHepsiBuradaAnaSayfa {

	SeleniumAbstractPage lib= new SeleniumAbstractPage();
	private final WebDriver driver;
public PageHepsiBuradaAnaSayfa() {

	this.driver= SeleniumAbstractTest.getDriver();
	PageFactory.initElements(driver, this);
		
}

@FindBy (how =How.XPATH, using ="//input[@placeholder='Ürün, kategori veya marka ara']")
WebElement txtUrunAra;
@FindBy (how =How.XPATH, using ="//div[@class='SearchBoxOld-buttonContainer']")
WebElement btnUrunAra;
@FindBy (how =How.XPATH, using ="//a[contains(text(),'Çok satanlar')]")
List <WebElement> cntrlUrunlerPage;
@FindBy (how =How.XPATH, using ="//span[@id='shoppingCart']")
WebElement btnSepetim;
@FindBy (how =How.XPATH, using ="//h1[contains(text(),'Samsung')]")
WebElement txtAratilanUrunAdi;
@FindBy (how =How.XPATH, using ="//button[@id='addToCart']")
WebElement btnSepeteEkle;
@FindBy (how =How.LINK_TEXT, using ="2")
WebElement btnSecondPage;

@Step({"<UrunAdi> 'ni ara ve gelen sonuclari kontrol et"})
public PageHepsiBuradaUrunler UrunArama(String UrunAdi) throws InterruptedException {
	Thread.sleep(2000);
	txtUrunAra.sendKeys(UrunAdi);
	btnUrunAra.click();
	Thread.sleep(2000);
	lib.Control(txtAratilanUrunAdi.getText().contains("Samsung"),"Samsung ile ilgili aramalarin geldigi gorulur","Hata! Samsung aramalari listelenmedi");
	return new PageHepsiBuradaUrunler();
}
    @Step({"Sepete tikla"})
	public PageHepsiBuradaSepetim Sepetim() {
	btnSepetim.click();
	return new PageHepsiBuradaSepetim();
}
	public PageHepsiBuradaAnaSayfa SayfaDegis() {
		btnSecondPage.click();
		return this;
	}
	@Step({"Urunu sepete ekle"})
	public PageHepsiBuradaAnaSayfa SepeteEkle() {
		btnSepeteEkle.click();
		log.info("Urun sepete eklendi");
		return this;
	}
}

