package com.proyectoSerenity.stepDefinitions;

import com.proyectoSerenity.actors.Usuario;
import com.proyectoSerenity.interactions.EsperaLoader;
import com.proyectoSerenity.questions.SistemaQuestion;
import com.proyectoSerenity.targets.Etiquetas;
import com.proyectoSerenity.tasks.Formulario;
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

public class CompraFinal {

    Usuario usuario = JsonReader.leer("datos/datos.json", Usuario.class);


    @Given(value = "que el usuario ha iniciado sesión correctamente")
    public void loginSistema(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(System.getProperty("webdriver.base.url")),
                EsperaLoader.desaparezca(),
                LoginPage.builder()
                        .withEmail(usuario.getLogin().getCorreo())
                        .withPassword(usuario.getLogin().getContrasenia())
                        .build()

        );
    }

    @And(value = "selecciona los productos {string} y {string}")
    public void seleccionarPorducto(String producto1, String producto2){
        List<String> productos = Arrays.asList(producto1, producto2);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProductosCarrito.conProductos(productos),
                Click.on(Etiquetas.BOTON_VERIFICAR_CARRITO),
                Click.on(Etiquetas.BOTON_CHECKOUT)
        );

    }

    @And(value = "se encuentra en la página {string}")
    public void verificarPage(String texto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_CHECKOUT)).isEqualTo("Checkout: Your Information")
        );
    }


    @When(value = "completa el formulario con el nombre {string}, el apellido {string} y el código postal {string} además pulsar \"Continue\"")
    public void completarFormulario(String nombre, String apellido, String codigo){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Formulario.builder()
                        .withNombre(nombre)
                        .withApellido(apellido)
                        .withCodigo(codigo)
                        .build()
        );
    }


    @Then(value = "debería en página existir {string}")
    public void identificadorPage(String texto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_DESCRIPCION)).isEqualTo(texto)
        );
    }


    @When(value = "presiona el botón \"Finish\"")
    public void finalizar(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Etiquetas.BOTON_FINISH)
        );
    }

    @Then(value = "debería ver el mensaje de confirmación {string}")
    public void compraExitosa(String texto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(SistemaQuestion.del(TEXTO_FINAL)).contains(texto)
        );
    }
}
