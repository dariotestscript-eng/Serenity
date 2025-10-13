package com.proyectoSerenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.Arrays;
import java.util.List;

import static com.proyectoSerenity.targets.Etiquetas.BOTON_AGREGAR_CARRITO;

public class ProductosCarrito implements Task {

    private final List<String> productos;

    private ProductosCarrito(List<String> productos) {
        this.productos = productos;
    }

    public static ProductosCarrito conProductos(List<String> productos) {
        return new ProductosCarrito(productos);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        productos.forEach(producto ->
                actor.attemptsTo(
                        Scroll.to(BOTON_AGREGAR_CARRITO.of(producto)),
                        Click.on(BOTON_AGREGAR_CARRITO.of(producto))
                )
        );
    }
}
