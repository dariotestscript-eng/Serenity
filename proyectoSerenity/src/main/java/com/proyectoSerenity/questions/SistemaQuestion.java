package com.proyectoSerenity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.targets.Target;

public class SistemaQuestion implements Question<String> {

    // Definimos una variable
    private final Target elemento;

    // Método Constructuor
    public SistemaQuestion(Target elemento){
        this.elemento = elemento;
    }

    //Sibreescribir la clase
    @Override
    public String answeredBy(Actor actor) {
        return TextContent.of(elemento).answeredBy(actor).trim();
    }

    public static SistemaQuestion del(Target elemento){
        return new SistemaQuestion(elemento);
    }

}
