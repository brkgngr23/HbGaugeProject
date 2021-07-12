package selenium.hepsiburada;

import org.testng.annotations.Test;

import com.hepsiburada.pages.selenium.hepsiburada.HepsiBurada;

public class HepsiBuradaLoginTest extends HepsiBurada {

@Test
public void HepsiBurada_Login() throws InterruptedException {
	startTest()
			.login()
			.UrunArama("Samsung")
			.SayfaDegis()
			.UrunSec()
			.SepeteEkle()
			.Sepetim()
			.UrunAdiKarsilastir()
			.UrunuKaldirVeKontrolEt();
}

}