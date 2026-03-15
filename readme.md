# Carrito de Compras

Este proyecto contiene una implementación básica de un carrito de compras en Java.

## Estructura

- `CarritoDeCompras.java`: clase que gestiona los ítems, cantidades y cálculo de totales.
- `Item.java`: representación de un producto con validaciones de precio y nombre.
- `Main.java`: programa principal separado que usa `CarritoDeCompras`.

## Puntos importantes

- El carrito usa un `HashMap` para escalar mejor en grandes cantidades de elementos.
- Se manejan excepciones si se intenta quitar un ítem que no existe.
- Las validaciones de precio se realizan en `Item`; se evita precio negativo o fuera de rango.
- El detalle del carrito se genera a partir del `toString()` del `Item` y del propio carrito.
