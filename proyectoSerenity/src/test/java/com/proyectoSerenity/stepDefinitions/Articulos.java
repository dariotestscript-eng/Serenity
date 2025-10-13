package com.proyectoSerenity.stepDefinitions;

import com.proyectoSerenity.actors.Usuario;
import com.proyectoSerenity.interactions.EsperaLoader;
import com.proyectoSerenity.questions.SistemaQuestion;
import com.proyectoSerenity.tasks.LoginPage;
import com.proyectoSerenity.utils.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.proyectoSerenity.targets.Etiquetas.LOGIN_ARTICULO;

public class Articulos {

    @Given(value = "que el usuario abre la página de SauceDemo")
    public void aperturaLink(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(System.getProperty("webdriver.base.url")),
                EsperaLoader.desaparezca()
        );
    }

    @When(value = "el usuario ingresa el nombre de usuario y la contraseña, y pulsa el botón \"Login\"")
    public void ingresoCredencialesValidas(){
        Usuario usuario = JsonReader.leer("datos/datos.json", Usuario.class);

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginPage.builder()
                        .withEmail(usuario.getLogin().getCorreo())
                        .withPassword(usuario.getLogin().getContrasenia())
                        .build()
        );
    }

    @Then(value = "el usuario visualiza el texto Products")
    public void verificarTexto(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                EsperaLoader.desaparezca(),
                Ensure.that(SistemaQuestion.del(LOGIN_ARTICULO)).isEqualTo("Products")
        );
    }

}
