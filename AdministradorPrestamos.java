import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorPrestamos {
    private static AdministradorPrestamos instancia;
    private final Map<String, Prestamo> prestamosActivosPorEjemplar;

    private AdministradorPrestamos() {
        this.prestamosActivosPorEjemplar = new HashMap<>();
    }

    public static AdministradorPrestamos getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorPrestamos();
        }
        return instancia;
    }

    public boolean registrarPrestamo(String idEjemplar, String idSocio, LocalDate fecha) {
        if (idEjemplar == null || idEjemplar.trim().isEmpty() || idSocio == null || idSocio.trim().isEmpty()) {
            return false;
        }
        String claveEjemplar = idEjemplar.trim();
        if (prestamosActivosPorEjemplar.containsKey(claveEjemplar)) {
            return false; // Ya se encuentra prestado
        }
        prestamosActivosPorEjemplar.put(claveEjemplar, new Prestamo(claveEjemplar, idSocio, fecha));
        return true;
    }

    public boolean registrarDevolucion(String idEjemplar) {
        if (idEjemplar == null || idEjemplar.trim().isEmpty()) {
            return false;
        }
        String claveEjemplar = idEjemplar.trim();
        if (!prestamosActivosPorEjemplar.containsKey(claveEjemplar)) {
            return false; // Sin préstamo activo: no modifica estado
        }
        prestamosActivosPorEjemplar.remove(claveEjemplar);
        return true;
    }

    public List<Prestamo> consultarPrestamosDeSocio(String idSocio) {
        List<Prestamo> resultado = new ArrayList<>();
        if (idSocio == null) {
            return resultado;
        }
        String socioBuscado = idSocio.trim();
        for (Prestamo prestamo : prestamosActivosPorEjemplar.values()) {
            if (prestamo.getIdSocio().equals(socioBuscado)) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }
}