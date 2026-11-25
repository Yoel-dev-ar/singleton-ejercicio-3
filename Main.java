public class Main {
    public static void main(String[] args) {
        LibroRegistroMovimientos libroCaja = LibroRegistroMovimientos.getInstancia();
        LibroRegistroMovimientos libroSeguridad = LibroRegistroMovimientos.getInstancia();

        libroCaja.anotarMovimiento("CAJA", "Juan Pérez", "Transfirió $200.000");
        libroSeguridad.anotarMovimiento("SEGURIDAD", "María Gómez", "Bloqueó tarjeta por extravío");
        libroCaja.anotarMovimiento("INVERSIONES", "Juan Pérez", "Abrió Plazo Fijo por $500.000");

        libroSeguridad.leerLibroCompleto();
        System.out.println("\n¿Es el mismo libro?: " + (libroCaja == libroSeguridad));
    }
}