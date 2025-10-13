package com.proyectoSerenity.stepDefinitions;

import com.proyectoSerenity.actors.Usuario;
import com.proyectoSerenity.interactions.EsperaLoader;
import com.proyectoSerenity.questions.SistemaQuestion;
import com.proyectoSerenity.targets.Etiquetas;
import com.proyectoSerenity.tasks.LoginPage;
import com.proyectoSerenity.tasks.ProductosCarrito;
import com.proyectoSerenity.utils.JsonReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Arrays;
import java.util.List;

import static com.proyectoSerenity.targets.Etiquetas.*;


public class VerificarCarrito {

    Usuario usuario = JsonReader.leer("datos/datos.json", Usuario.class);
    List<String> productos = Arrays.asList(usuario.getCompra().getArticulo4(), usuario.getCompra().getArticulo6());

    @Given(value = "que el usuario inicia sesión exitosamente y selecciona productos")
    public void seleccionarArticulo(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(System.getProperty("webdriver.base.url")),
                EsperaLoader.desaparezca(),
                LoginPage.builder()
                        .withEmail(usuario.getLogin().getCorreo())
                        .withPassword(usuario.getLogin().getContrasenia())
                        .build(),
                ProductosCarrito.conProductos(productos)
        );
    }

    @When(value = "el usuario pulsa el ícono del carrito de compras")
    public void paginaCarrito(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Etiquetas.BOTON_VERIFICAR_CARRITO)
        );
    }

    @Then(value = "el usuario visualiza el texto {string}")
    public void verificarTexto(String titulo){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_PRODUCTO_VERIFICAR)).isEqualTo(titulo)
        );
    }

    @And(value = "puede ver los productos seleccionados")
    public void verificarProducto(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_PRODUCTO_UNO)).isEqualTo(usuario.getCompra().getArticulo4()),
                Ensure.that(SistemaQuestion.del(TEXTO_PRODUCTO_DOS)).isEqualTo(usuario.getCompra().getArticulo6())
        );
    }

}
