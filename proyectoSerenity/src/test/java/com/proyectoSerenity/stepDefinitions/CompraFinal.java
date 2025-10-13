package com.proyectoSerenity.stepDefinitions;

import com.proyectoSerenity.actors.Usuario;
import com.proyectoSerenity.interactions.EsperaLoader;
import com.proyectoSerenity.questions.SistemaQuestion;
import com.proyectoSerenity.targets.Etiquetas;
import com.proyectoSerenity.tasks.Formulario;
import com.proyectoSerenity.tasks.LoginPage;
import com.proyectoSerenity.tasks.ProductosCarrito;
import com.proyectoSerenity.utils.JsonReader;
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

public class CompraFinal {

    Usuario usuario = JsonReader.leer("datos/datos.json", Usuario.class);
    List<String> productos = Arrays.asList(usuario.getCompra().getArticulo4(), usuario.getCompra().getArticulo6());

    @Given(value = "que el usuario ha iniciado sesión y se encuentra en la página {string}")
    public void chequeoText(String texto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(System.getProperty("webdriver.base.url")),
                EsperaLoader.desaparezca(),
                LoginPage.builder()
                        .withEmail(usuario.getLogin().getCorreo())
                        .withPassword(usuario.getLogin().getContrasenia())
                        .build(),
                ProductosCarrito.conProductos(productos),
                Click.on(Etiquetas.BOTON_VERIFICAR_CARRITO),
                Click.on(Etiquetas.BOTON_CHECKOUT),
                Ensure.that(SistemaQuestion.del(TEXTO_CHECKOUT)).isEqualTo(texto)
        );
    }

    @When(value = "el usuario completa el formulario con el Nombre {string}, el Apellido {string} y el Código Postal {string}")
    public void completarFormulario(String nombre, String apellido, String codigo){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Formulario.builder()
                        .withNombre(nombre)
                        .withApellido(apellido)
                        .withCodigo(codigo)
                        .build()
        );
    }

    @Then(value = "el usuario visualiza el texto {string} al pulsar el botón \"Continue\"")
    public void pantallaDescripcion(String texto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_DESCRIPCION)).isEqualTo(texto)
        );
    }

    @When(value = "el usuario presiona el botón \"Finish\"")
    public void finalizar(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Etiquetas.BOTON_FINISH)
        );
    }

    @Then(value = "el usuario ve el mensaje de compra exitosa: {string}")
    public void compraExitosa(String texto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_FINAL)).contains(texto)
                );
    }

}
