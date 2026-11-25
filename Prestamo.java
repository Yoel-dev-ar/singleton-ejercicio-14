import java.time.LocalDate;

public class Prestamo {
    private final String idEjemplar;
    private final String idSocio;
    private final LocalDate fecha;

    public Prestamo(String idEjemplar, String idSocio, LocalDate fecha) {
        if (idEjemplar == null || idEjemplar.trim().isEmpty()) {
            throw new IllegalArgumentException("El identificador del ejemplar es obligatorio.");
        }
        if (idSocio == null || idSocio.trim().isEmpty()) {
            throw new IllegalArgumentException("El identificador del socio es obligatorio.");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha del préstamo es obligatoria.");
        }
        this.idEjemplar = idEjemplar.trim();
        this.idSocio = idSocio.trim();
        this.fecha = fecha;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Ejemplar " + idEjemplar + " | Socio: " + idSocio + " | Fecha: " + fecha;
    }
}