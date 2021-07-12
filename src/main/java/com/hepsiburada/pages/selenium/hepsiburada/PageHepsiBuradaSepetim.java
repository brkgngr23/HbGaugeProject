package com.hepsiburada.pages.selenium.hepsiburada;

import java.util.List;

import com.hepsiburada.base.SeleniumAbstractTest;
import com.hepsiburada.basepage.SeleniumAbstractPage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.hepsiburada.utility.log;
import org.testng.Assert;

public class PageHepsiBuradaSepetim {
	private final WebDriver driver;
	SeleniumAbstractPage lib= new SeleniumAbstractPage();
public PageHepsiBuradaSepetim() {
	this.driver= SeleniumAbstractTest.getDriver();
	PageFactory.initElements(driver, this);
}


@FindBy (how =How.XPATH, using ="//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/div[2]/div[2]")
WebElement sepettekiUrunAdi;
@FindBy (how =How.XPATH, using ="//h1[contains(text(),'Sepetin şu an boş')]")
WebElement txtBosSepet;
@FindBy (how =How.CSS, using ="[aria-label='Ürünü Kaldır']")
WebElement btnUrunKaldir;

    @Step({"Sayfadaki ve sepetteki urunlerin aynı olması kontrolu"})
	public PageHepsiBuradaSepetim UrunAdiKarsilastir() throws InterruptedException {
		Thread.sleep(2000);
		String sepettekiUrununAdi=sepettekiUrunAdi.getText();
		lib.Control(PageHepsiBuradaUrunler.urununAdi.contains(sepettekiUrununAdi),"Sepetteki urunun kontrolu basarili","Hata ! Sepetteki urunun kontrolu basarisiz!");
		return this;
	}
	@Step({"Sepetteki urunu kaldir ve kontrol et"})
	public PageHepsiBuradaSepetim UrunuKaldirVeKontrolEt() throws InterruptedException {
		btnUrunKaldir.click();
		Thread.sleep(3000);
		lib.Control(txtBosSepet.getText().contains("Sepetin şu an boş"),"Urun Sepetinizden Kaldirildi","!Hata");
		return this;
	}
}