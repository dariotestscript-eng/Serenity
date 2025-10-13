package com.proyectoSerenity.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.proyectoSerenity.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty",
                "html:target/site/serenity/reporte/report_cucumber.html",
                "json:target/site/serenity/reporte/report_cucumber.json"
        }
        //tags = "@Login"
)
public class RunnerTest {
        @AfterClass
        public static void afterAll() {
                System.out.println();
                System.out.println();
                String userDir = System.getProperty("user.dir").replace("\\", "/");
                System.out.println("\n=========================================================== REPORTES CUCUMBER ===========================================================");
                System.out.println();System.out.println();
                System.out.println("HTML: file:///" + userDir + "/target/site/serenity/reporte/report_cucumber.html");
                System.out.println();System.out.println();
                System.out.println("============================================================= ================= ===========================================================");
        }
}

