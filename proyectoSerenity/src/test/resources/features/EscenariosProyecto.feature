Feature: Flujo de compra completo
  Como Usuario autenticado
  Quiero realizar una compra completa
  Para confirmar compra exitosa

  Scenario: Abrir la página SauceDemo
    Given el Usuario abre página SauceDemo
    Then debería visualizar el texto "Swag Labs"

  Scenario: Iniciar sesión con credenciales válidas
    Given que el usuario abre la página de SauceDemo
    When el usuario ingresa el nombre de usuario y la contraseña, y pulsa el botón "Login"
    Then el usuario visualiza el texto Products

  Scenario: Agregar 2 productos al carrito
    Given que el usuario inicia sesión correctamente y se encuentra en la página de productos
    When el usuario agrega 2 artículos al carrito
    Then el usuario debería ver el contador del carrito con el valor "2"
    And el usuario comprueba "Sauce Labs Backpack" en la pantalla


  Scenario: Visualizar el carrito
    Given que el usuario inicia sesión exitosamente y selecciona productos
    When el usuario pulsa el ícono del carrito de compras
    Then el usuario visualiza el texto "Your Cart"
    And puede ver los productos seleccionados


  Scenario Outline: Completar el formulario y finalizar la compra

    Given que el usuario ha iniciado sesión correctamente
    And selecciona los productos "<Producto1>" y "<Producto2>"
    And se encuentra en la página "Checkout: Your Information"
    When completa el formulario con el nombre "<First>", el apellido "<Last>" y el código postal "<Code>" además pulsar "Continue"
    Then debería en página existir "Checkout: Overview"
    When presiona el botón "Finish"
    Then debería ver el mensaje de confirmación "Thank you for your order"

    Examples:
      |Producto1               |Producto2                        |First   |Last     |Code  |
      |Sauce Labs Backpack     |Sauce Labs Fleece Jacket         |Viviana |Castillo |10115 |
      |Sauce Labs Fleece Jacket|Test.allTheThings() T-Shirt (Red)|Andres  |Gutierrez|202530|
      |Sauce Labs Bolt T-Shirt |Sauce Labs Backpack              |Tamara  |Aguilar  |31204 |


