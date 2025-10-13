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

  Scenario: Completar el formulario y finalizar la compra
    Given que el usuario ha iniciado sesión y se encuentra en la página "Checkout: Your Information"
    When el usuario completa el formulario con el Nombre "Viviana", el Apellido "Castillo" y el Código Postal "10115"
    Then el usuario visualiza el texto "Checkout: Overview" al pulsar el botón "Continue"
    When el usuario presiona el botón "Finish"
    Then el usuario ve el mensaje de compra exitosa: "Thank you for your order"


