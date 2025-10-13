# 🧪 Proyecto E2E Automatizado – Serenity BDD + Screenplay + Cucumber Reports + Gradle


## 1️⃣ Prerrequisitos


A continuación se detallan los requerimientos técnicos y versiones necesarias para ejecutar correctamente el proyecto en el entorno local:

|      Tecnología       |                     Versión recomendada                        | 
|-----------------------|----------------------------------------------------------------|
| **Sistema operativo** | Windows 10/11 (x64)                                            | 
| **IDE**               | Intellij IDEA (Community Edition 2024.3.5)                     | 
| **Java JDK**          | 17 o superior                                                  |
| **Gradle**            | Versión 7.6.1                                                  | 
| **Navegador**         | Google Chrome (última versión estable)                         | 
| **ChromeDriver**      | Administrador automáticamente mediante WebDriver Manager 5.6.1 | 
|----------------------------------------------------------------------------------------|
|                       | Serenity BDD Core: 3.6.22                                      |
|                       | Serenity Screenplay + WebDriver: 3.6.22                        |
|**Frameworks**         | Serenity Cucumber: 3.6.22                                      |
|**Librerías**          | JUnit: 4.13.2                                                  |
|                       | Selenium Java: 4.14.1                                          |
|                       |  WebDriverManager: 5.6.2                                       |
|----------------------------------------------------------------------------------------|

📂 **Sitio bajo prueba:** [https://www.saucedemo.com/]


---

## 2️⃣ Comandos de instalación


Ejecutar los siguientes comandos desde la raíz del proyecto para descargar y configurar todas las dependencias necesarias.

🚨 <span style="color:red">**Nota importante:**</span>  
> Si con anterioridad se descargo el repositorio no volver ha hacerlo

> La unidad debe ser donde se descargó el repositorio

> **Ejemplos:**
> - Unidad **C:** `dir /s /ad C:\*proyectoSerenity*`  
> - Unidad **D:** `dir /s /b D:\*proyectoSerenity*`

El resultado del anterior comando utilizarlo con cd para cambiar a la carpeta proyectoSerenity


### 🔹 Clonar el repositorio
Previamente presiona Win + R, escribe cmd y da Enter → abre Command Prompt (CMD)
```bash
git clone https://github.com/dariotestscript-eng/Serenity.git
cd proyectoSerenity
```
---


## 3️⃣ Instrucciones para ejecutar los tests


🔸 **Paso 1. Verificar configuración del entorno**  
Asegúrate de que las variables de entorno `JAVA_HOME` y `GRADLE_HOME` estén correctamente configuradas y que Gradle reconozca la versión 7.6.1 y JDK 17 por ejemplo: 7.0.16


🔸 **Paso 2. Descargar dependencias del proyecto y Ejecutar las pruebas automatizadas**
```bash
gradlew clean test -x aggregate
```


🔸 **Paso 3. Generar y visualizar los reportes de ejecución**  

El proyecto utiliza reporte nativo de **Cucumber** 


- 📁 **Reporte Cucumber:** `target/site/serenity/reporte/report_cucumber.html`


Para abrir el reporte en el navegador:
```bash
start target/site/serenity/reporte/report_cucumber.html
```


---


## 4️⃣ Información adicional


### 📘 Descripción funcional del flujo automatizado

El escenario E2E automatizado corresponde al flujo de compra exitoso en **SauceDemo**, incluyendo los pasos:


1. Inicio de sesión con:
   - Usuario: `standard_user`
   - Contraseña: `secret_sauce`
2. Agregar dos productos al carrito.
3. Visualizar el carrito de compras.
4. Completar el formulario con nombre, apellido y código postal (leídos desde un archivo **JSON**).
5. Finalizar la compra y validar el mensaje final:
   ✅ “THANK YOU FOR YOUR ORDER”


---

### Estructura de Proyecto

```
proyectoSerenity/
├── build.gradle
├── README.md
├── conclusiones.txt
└── src
    ├── main
    │   └── java
    │       └── com/proyectoSerenity
    │           ├── actors
    │           ├── interactions
    │           ├── questions
    │           ├── tasks
    │           ├── targets
    │           └── utils
    └── test
        ├── java
        │   └── com/proyectoSerenity
        │       ├── runners
        │       │   └── RunnerTest.java
        │       └── stepDefinitions
        │           ├── CstepDefinition.java
        │           └── hooks
        │               └── Hook.java
        └── resources
            ├── features
            │   └── EscenariosProyecto.feature
            ├── datos
            │   └── datos.json
            └── serenity.config

```

---

### 🧩 Patrón Screenplay implementado

Se utiliza el patrón de diseño **Screenplay**, que promueve la reutilización, modularidad y claridad del código.


|        Carpeta      |                          Descripción                                                    |
|-------------------- |-----------------------------------------------------------------------------------------|
| `actors/`           | Definición y configuración del actor que ejecuta las tareas, interacciones y preguntas. |
| `tasks/`            | Acciones que el actor ejecuta (Login, AgregarProductos, FinalizarCompra).               |
| `interactions/`     | Acciones más específicas sobre los elementos de la interfaz.                            |
| `targets/`          | Localizadores de elementos web (Page Objects).                                          |
| `questions/`        | Validaciones del resultado esperado.                                                    |
| `utils/`            | Mapeo de datos desde el archivo JSON.                                                   |
|---------------------------------------------------------------------------------------------------------------|

#### Ejemplo de uso:

```java
actor.attemptsTo(
    Login.conCredenciales("standard_user", "secret_sauce"),
    AgregarProductos.alCarrito(),
    FinalizarCompra.conDatos("datosCompra.json")
);
```


---


### 📂 Datos parametrizados por JSON

Los datos utilizados en el formulario de compra se obtienen de un archivo JSON ubicado en:


```
src/test/resources/datos/datos.json
```


#### Ejemplo de estructura JSON (cualquiera):

```json
{
  "nombre": "Dario",
  "apellido": "QA",
  "codigoPostal": "593"
}
```


---


### 🧾 Escenario Gherkin (ejemplo funcional)

```gherkin
Feature: Flujo de compra en SauceDemo

  Scenario: Iniciar sesión con credenciales válidas
    Given que el usuario abre la página de SauceDemo
    When el usuario ingresa el nombre de usuario y la contraseña, y pulsa el botón "Login"
    Then el usuario visualiza el texto Products

```
Nota:

El flujo de compra completo fue dividido en 5 escenarios, uno por pantalla: Home, Login, Productos, Carrito y Checkout.

Esto permite validar si se requiere mensajes, campos obligatorios y formatos de datos en cada pantalla de forma independiente, lo que facilita mantenimiento y optimización futura de pruebas.

---


### 🧠 Observaciones

- Proyecto desarrollado en IntelliJ IDEA, con Gradle 7.6.1 y JDK 17.  
- Datos de entrada leídos desde archivos JSON.  
- Generación de reportes en Cucumber.  
- Serenity BDD integra el patrón Screenplay para manejar tareas, actores y validaciones.  
- Flujo E2E validado exitosamente.


---


### 👤 Autor
**Nombre:** *Darío Javier Sotalín Pillajo*  
**Rol:** Analista QA
**Repositorio GitHub:** [https://github.com/dariotestscript-eng/Serenity.git]  

