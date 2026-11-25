import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibroRegistroMovimientos {
    private static LibroRegistroMovimientos instancia;
    private List<String> renglones;
    private DateTimeFormatter formatoHora;

    private LibroRegistroMovimientos() {
        this.renglones = new ArrayList<>();
        this.formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    public static LibroRegistroMovimientos getInstancia() {
        if (instancia == null) {
            instancia = new LibroRegistroMovimientos();
        }
        return instancia;
    }

    public void anotarMovimiento(String sector, String cliente, String accion) {
        String hora = LocalTime.now().format(formatoHora);
        String linea = "[" + hora + "] [" + sector + "] Cliente " + cliente + " -> " + accion;
        renglones.add(linea);
        System.out.println("Anotado: " + linea);
    }

    public void leerLibroCompleto() {
        System.out.println("\n=== LIBRO ÚNICO DE MOVIMIENTOS DEL BANCO ===");
        for (String renglon : renglones) {
            System.out.println(renglon);
        }
    }
}