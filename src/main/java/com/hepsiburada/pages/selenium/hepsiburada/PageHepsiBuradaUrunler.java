package com.hepsiburada.pages.selenium.hepsiburada;

import java.util.List;
import com.hepsiburada.base.SeleniumAbstractTest;
import com.hepsiburada.basepage.SeleniumAbstractPage;
import com.hepsiburada.utility.log;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageHepsiBuradaUrunler {
	private final WebDriver driver;
	SeleniumAbstractPage lib= new SeleniumAbstractPage();
	public static String urununAdi="";
public PageHepsiBuradaUrunler() {
	this.driver= SeleniumAbstractTest.getDriver();
	PageFactory.initElements(driver, this);
		
}

@FindBy (how =How.XPATH, using ="//h1[@id='product-name']")
WebElement urunAdi;
@FindBy (how =How.XPATH, using ="//body/div[2]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[1]/div[2]")
WebElement btnUrunSec;
@FindBy (how =How.LINK_TEXT, using ="2")
WebElement btnSecondPage;
@Step({"Sayfadaki 3. urunun adini kaydet ve sec"})
public PageHepsiBuradaAnaSayfa UrunSec() {
	btnUrunSec.click();
	urununAdi=urunAdi.getText();
	return new PageHepsiBuradaAnaSayfa();
}
@Step({"2. sayfaya gecildi"})
public PageHepsiBuradaUrunler SayfaDegis() {
	btnSecondPage.click();
	// 2. sayfada olduğumuzun kontrolünü yaparken 2 linktext'inin rengini kontrol ediyoruz
	String rgbFormat = btnSecondPage.getCssValue("background-color");
	String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
	lib.Control(hexcolor.contains("#ff6000"),"2. Sayfaya geçildi","Hata! 2. sayfaya geçilemedi");
	return this;
	}

}