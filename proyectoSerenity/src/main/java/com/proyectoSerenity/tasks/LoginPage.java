package com.proyectoSerenity.tasks;

import com.proyectoSerenity.targets.Etiquetas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginPage implements Task {

    private String valor1;
    private String valor2;

    public static LoginTaskBuilder builder(){
        return new LoginTaskBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(valor1).into(Etiquetas.Text_Correo),
                Enter.theValue(valor2).into(Etiquetas.Text_Contrasenia),
                Click.on(Etiquetas.Boton_Login)
        );
    }

    public static class LoginTaskBuilder{
        private final LoginPage task = new LoginPage();

        public LoginTaskBuilder withEmail(String email){
            task.valor1 = email;
            return this;
        }

        public LoginTaskBuilder withPassword(String password){
            task.valor2 = password;
            return this;
        }

        public LoginPage build(){
            return task;
        }

    }
}
