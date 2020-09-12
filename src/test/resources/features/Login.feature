Feature: Como cliente, quiero ingresar los credenciales de mi cuenta, para ingresar al sitio de compras

  @Login
  Scenario Outline: El cliente inicia sesión en el sitio de compras
    Given el cliente se encuentra en la pagina de Home
    When el cliente hace click en el botón Sign in
    Then el cliente verifica que fue redireccionado a la pantalla de Login

    When el cliente ingresa su email <email>
    And  el cliente ingresa su password <pass>
    And el cliente hace click en el botón Sign in
    Then el cliente verifica que fue redireccionado a la pantalla de My Account

    Examples:
      | email                                    | pass     |
      | testing.crowdar@testing.net.com          | 12345    |
      | testing.ssdddadwecrowdar@testing.net.com | asds1233 |
