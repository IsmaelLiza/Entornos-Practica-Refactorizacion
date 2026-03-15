import java.util.Objects;

/**
 * Representa un ítem que puede agregarse al carrito.
 * Contiene validación de precio para evitar valores negativos o desorbitados.
 */
public class Item {

    public static final double PRECIO_MINIMO = 0.0;
    public static final double PRECIO_MAXIMO = 10_000.0;

    private String nombre;
    private double precio;

    public Item(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del ítem no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < PRECIO_MINIMO || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException("Precio fuera de rango válido: " + precio);
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - " + CarritoDeCompras.MONEDA + String.format("%.2f", precio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(nombre, item.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}