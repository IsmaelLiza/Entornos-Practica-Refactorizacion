public class Main {
    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();

        Item item1 = new Item("Camiseta", 20.99);
        Item item2 = new Item("Pantalones", 34.99);

        carrito.agregarItem(item1, 2);
        carrito.agregarItem(item2, 1);

        System.out.println(carrito);
    }
}