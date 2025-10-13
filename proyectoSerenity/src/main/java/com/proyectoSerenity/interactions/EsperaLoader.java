package com.proyectoSerenity.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.proyectoSerenity.targets.Etiquetas.Loader;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class EsperaLoader implements Interaction {
    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(WaitUntil.the(Loader, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static EsperaLoader desaparezca(){
        return Tasks.instrumented(EsperaLoader.class);
    }
}
