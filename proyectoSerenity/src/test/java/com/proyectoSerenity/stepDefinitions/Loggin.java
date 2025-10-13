package com.proyectoSerenity.stepDefinitions;

import com.proyectoSerenity.interactions.EsperaLoader;
import com.proyectoSerenity.questions.SistemaQuestion;
import com.proyectoSerenity.targets.Etiquetas;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

//import static com.proyectoSerenity.targets.Etiquetas.LOGIN_MENSAJE;
import static com.proyectoSerenity.targets.Etiquetas.*;

public class Loggin {

    // Step: Abre la página de compras
    @Given(value = "el Usuario abre página SauceDemo")
    public void abrirEnlace(){
        OnStage.theActorCalled("cliente").attemptsTo(
                Open.url(System.getProperty("webdriver.base.url")),
                EsperaLoader.desaparezca()
        );
    }

    // Step: Verificar texto en la pantalla Loggin
    @Then(value = "debería visualizar el texto \"Swag Labs\"")
    public void verificarTexto(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(LOGIN_MENSAJE)).isEqualTo("Swag Labs"),
                Click.on(Text_Correo)
        );
    }


}
