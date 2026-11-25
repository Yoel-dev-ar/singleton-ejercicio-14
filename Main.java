import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AdministradorPrestamos mostrador1 = AdministradorPrestamos.getInstancia();
        AdministradorPrestamos mostrador2 = AdministradorPrestamos.getInstancia();

        // Mostrador 1 presta EJ-001 al socio S-10
        boolean ok1 = mostrador1.registrarPrestamo("EJ-001", "S-10", LocalDate.now());
        System.out.println("Mostrador 1 presta EJ-001 a S-10: " + ok1);

        // Mostrador 2 intenta prestar el mismo ejemplar EJ-001 a otro socio -> rechazado
        boolean ok2 = mostrador2.registrarPrestamo("EJ-001", "S-25", LocalDate.now());
        System.out.println("Mostrador 2 intenta prestar EJ-001 a S-25: " + ok2);

        // Devolución inexistente -> rechazada
        boolean devInvalida = mostrador2.registrarDevolucion("EJ-999");
        System.out.println("Devolución de EJ-999 sin préstamo activo: " + devInvalida);

        // Préstamos activos del socio S-10
        System.out.println("Préstamos activos de S-10: " + mostrador2.consultarPrestamosDeSocio("S-10"));

        // Devolución válida y nuevo préstamo
        boolean devOk = mostrador1.registrarDevolucion("EJ-001");
        System.out.println("Devolución de EJ-001: " + devOk);
        boolean ok3 = mostrador2.registrarPrestamo("EJ-001", "S-25", LocalDate.now());
        System.out.println("Mostrador 2 presta EJ-001 a S-25 tras devolución: " + ok3);
    }
}