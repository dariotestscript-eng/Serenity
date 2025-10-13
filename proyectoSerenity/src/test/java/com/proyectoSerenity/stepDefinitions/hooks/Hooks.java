package com.proyectoSerenity.stepDefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        //options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");



        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1366, 768));


        OnStage.theActorCalled("cliente")
                .can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            // Esperar 5 segundos antes de cerrar
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("La espera fue interrumpida");

        }
        // Cerrar el navegador después de cada scenario
        if (driver != null) {
            driver.quit();
        }

        // Limpiar los actores de Screenplay
        OnStage.drawTheCurtain();
    }

}
