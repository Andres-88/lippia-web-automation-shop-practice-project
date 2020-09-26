Feature: Como usuario logueado quiero realizar una compra

  @Shopping
  Scenario Outline: el cliente busca un producto
    Given el cliente hace foco en el buscador de productos
    When el cliente ingresa <producto> en el buscador
    Then el cliente es redirigido a la pantallas de resultados

    Examples:
      | producto  |
      | dress     |

  @Shopping
  Scenario Outline: el cliente selecciona un producto
    Given el cliente se encuentra en la pagina de resultados
    When el cliente elige un <producto>
    Then el cliente es redirigido al producto que selecciono

    Examples:
      | producto  |
      | dress     |

  @Shopping
  Scenario Outline: el cliente selecciona las opciones del producto
    Given el cliente se encuentra en la pagina del producto seleccionado
    When el ingresa una <cantidad>
    And selecciona un <talle>
    And elige un <color>
    And hace click en el botón Add To Cart
    And clickea el botón Proceed to Checkout
    Then el cliente es redireccionado al carrito de compra

    Examples:
      | cantidad  |   talle     |   color   |
      |   1       |     S       |   negro   |

  @Shopping
  Scenario: el cliente compra un producto
    Given el cliente se encuentra en el carrito de compras y está registrado
    When el cliente hace click en "proceed to checkout"
    And el cliente se loggea y hace click en el botón "Sign in"
    And el cliente corfirma la dirección haciendo click en "proceed to checkout"
    And el cliente acepta los terminos de servicios haciendo click en el checkbox y clickea en "proceed to checkout"
    And el cliente elige la opcion de pago
    And el cliente hace click en el boton de "I confirm my order"
    Then el cliente es redireccionado a la pantalla de "order confirmation"