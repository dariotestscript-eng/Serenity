package com.proyectoSerenity.tasks;

import com.proyectoSerenity.targets.Etiquetas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Formulario implements Task {

    private String valor1;
    private String valor2;
    private String valor3;

    public static Formulario.FormularioTaskBuilder builder(){
        return new Formulario.FormularioTaskBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(valor1).into(Etiquetas.Text_Nombre),
                Enter.theValue(valor2).into(Etiquetas.Text_Apellido),
                Enter.theValue(valor3).into(Etiquetas.Text_Codigo),
                Click.on(Etiquetas.Boton_Continuar)
        );
    }

    public static class FormularioTaskBuilder{
        private final Formulario task = new Formulario();

        public Formulario.FormularioTaskBuilder withNombre(String nombre){
            task.valor1 = nombre;
            return this;
        }

        public Formulario.FormularioTaskBuilder withApellido(String apellido){
            task.valor2 = apellido;
            return this;
        }

        public Formulario.FormularioTaskBuilder withCodigo(String codigo){
            task.valor3 = codigo;
            return this;
        }

        public Formulario build(){
            return task;
        }

    }
}
