import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Representa un carrito de compras que guarda ítems y cantidades.
 * La responsabilidad de esta clase es manejar el contenido del carrito,
 * el cálculo de totales y la validación de entrada.
 */
public class CarritoDeCompras {

    public static final String MONEDA = "€";
    public static final String CABECERA = "Detalles del carrito de compras:";

    private final Map<Item, Integer> items = new HashMap<>();

    public void agregarItem(Item item) {
        agregarItem(item, 1);
    }

    public void agregarItem(Item item, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        items.merge(item, cantidad, Integer::sum);
    }

    /**
     * Elimina un ítem completo del carrito.
     * @throws IllegalArgumentException si el ítem no está presente.
     */
    public void removerItem(Item item) {
        if (!items.containsKey(item)) {
            throw new IllegalArgumentException("El ítem no existe en el carrito: " + item.getNombre());
        }
        items.remove(item);
    }

    /**
     * Devuelve el total acumulado de todos los ítems, teniendo en cuenta la cantidad de cada uno.
     */
    public double calcularTotal() {
        return items.entrySet()
            .stream()
            .mapToDouble(e -> e.getKey().getPrecio() * e.getValue())
            .sum();
    }

    /**
     * Devuelve una vista inmodificable del contenido del carrito.
     */
    public Map<Item, Integer> obtenerItems() {
        return Collections.unmodifiableMap(items);
    }

    @Override
    public String toString() {
        String detalle = items.entrySet()
            .stream()
            .map(e -> String.format("%s x%d", e.getKey(), e.getValue()))
            .collect(Collectors.joining("\n"));

        return CABECERA + "\n" +
               detalle + "\n" +
               "Total: " + MONEDA + String.format("%.2f", calcularTotal());
    }
}