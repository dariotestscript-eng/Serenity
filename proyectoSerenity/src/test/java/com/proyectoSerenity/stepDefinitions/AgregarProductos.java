package com.proyectoSerenity.stepDefinitions;

import com.proyectoSerenity.actors.Usuario;
import com.proyectoSerenity.interactions.EsperaLoader;
import com.proyectoSerenity.questions.SistemaQuestion;
import com.proyectoSerenity.tasks.LoginPage;
import com.proyectoSerenity.tasks.ProductosCarrito;
import com.proyectoSerenity.utils.JsonReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.Arrays;
import java.util.List;

import static com.proyectoSerenity.targets.Etiquetas.NUMERO_ARTICULO;
import static com.proyectoSerenity.targets.Etiquetas.TEXTO_UNO_ARTICULO;


public class AgregarProductos {

    Usuario usuario = JsonReader.leer("datos/datos.json", Usuario.class);

    @Given(value="que el usuario inicia sesión correctamente y se encuentra en la página de productos")
    public void paginaArticulos(){

        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(System.getProperty("webdriver.base.url")),
                EsperaLoader.desaparezca(),
                LoginPage.builder()
                        .withEmail(usuario.getLogin().getCorreo())
                        .withPassword(usuario.getLogin().getContrasenia())
                        .build()
        );
    }

    @When(value = "el usuario agrega 2 artículos al carrito")
    public void agregaProducto(){
        List<String> productos = Arrays.asList(usuario.getCompra().getArticulo4(), usuario.getCompra().getArticulo6());
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProductosCarrito.conProductos(productos)
        );
    }

    @Then("el usuario debería ver el contador del carrito con el valor {string}")
    public void contadorCarrito(String numeroArticulo){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Scroll.to(NUMERO_ARTICULO),
                Ensure.that(SistemaQuestion.del(NUMERO_ARTICULO)).isEqualTo(numeroArticulo)
        );
    }

    @And(value = "el usuario comprueba \"Sauce Labs Backpack\" en la pantalla")
    public void textoArticulo(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_UNO_ARTICULO)).isEqualTo(usuario.getCompra().getArticulo1())
        );
    }

}
