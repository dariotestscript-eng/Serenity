package com.proyectoSerenity.targets;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Etiquetas {
    public static final Target Loader = Target.the("Loader loggin").locatedBy(".loader");
    public static final Target LOGIN_MENSAJE = Target.the("Login Mensaje").locatedBy("//*[contains(text(),'Swag Labs')]");

    public static final Target Text_Correo = Target.the("Campo Usarname").located(By.cssSelector("input[data-test='username']"));
    public static final Target Text_Contrasenia = Target.the("Campo Password").located(By.cssSelector("input[data-test='password']"));
    public static final Target Boton_Login = Target.the("Botón Ingresar").located(By.cssSelector("input[data-test='login-button']"));
    public static final Target LOGIN_ARTICULO = Target.the("Página Articulo").locatedBy("//*[contains(text(),'Products')]");

    public static final Target NUMERO_ARTICULO = Target.the("Número articulos").located(By.cssSelector("[data-test='shopping-cart-badge']"));
    public static final Target TEXTO_UNO_ARTICULO = Target.the("Página Compras").locatedBy("//*[contains(text(),'Sauce Labs Backpack')]");
    public static final Target BOTON_AGREGAR_CARRITO =
            Target.the("botón agregar actual producto")
                    .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item']//button");

    public static final Target BOTON_VERIFICAR_CARRITO = Target.the("Verificar Carrito").located(By.cssSelector("a[data-test='shopping-cart-link']"));
    public static final Target TEXTO_PRODUCTO_VERIFICAR = Target.the("Página Carrito").locatedBy("//*[contains(text(),'Your Cart')]");
    public static final Target TEXTO_PRODUCTO_UNO = Target.the("Producto Carrito1").locatedBy("//*[contains(text(),'Sauce Labs Fleece Jacket')]");
    public static final Target TEXTO_PRODUCTO_DOS = Target.the("Producto Carrito2").locatedBy("//*[contains(text(),'Test.allTheThings() T-Shirt (Red)')]");

    public static final Target BOTON_CHECKOUT = Target.the("Botón Checkout").located(By.cssSelector("button[data-test='checkout']"));
    public static final Target TEXTO_CHECKOUT = Target.the("Página Checkout").locatedBy("//*[contains(text(),'Checkout: Your Information')]");
    public static final Target Text_Nombre = Target.the("Campo Nombre").located(By.cssSelector("input[data-test='firstName']"));
    public static final Target Text_Apellido = Target.the("Campo Apellido").located(By.cssSelector("input[data-test='lastName']"));
    public static final Target Text_Codigo = Target.the("Campo Código").located(By.cssSelector("input[data-test='postalCode']"));
    public static final Target Boton_Continuar = Target.the("Botón Continuar").located(By.cssSelector("input[data-test='continue']"));
    public static final Target TEXTO_DESCRIPCION = Target.the("Página Descripción").locatedBy("//*[contains(text(),'Checkout: Overview')]");
    public static final Target BOTON_FINISH = Target.the("Botón Finish").located(By.cssSelector("button[data-test='finish']"));
    public static final Target TEXTO_FINAL = Target.the("Página Exitosa").locatedBy("//*[contains(text(),'Thank you for your order')]");




}
