package com.hepsiburada.pages.selenium.hepsiburada;

import java.lang.reflect.Method;


import com.thoughtworks.gauge.Step;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeMethod;

import com.hepsiburada.base.SeleniumAbstractTest;

public class HepsiBurada extends SeleniumAbstractTest {
	String chrome="chrome";
	String firefox="firefox";



	@BeforeMethod
	public void Before (Method method) {
	DOMConfigurator.configureAndWatch("log.xml");



}
    @Step({"Test basliyor,Chrome calistirildi"})
	public PageHepsiBuradaLogin startTest() {
		driver =super.setUpBrowser(chrome);
		return new PageHepsiBuradaLogin();
	}
}