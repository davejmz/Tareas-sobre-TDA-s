package ReservacionesParaUnTeatro;

public class Reservacion {
    private final String nombreCliente;
    private int numeroAsiento;

    public Reservacion(String nombreCliente, int numeroAsiento) {
        this.nombreCliente = nombreCliente;
        this.numeroAsiento = numeroAsiento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    @Override
    public String toString() {
        return "Reservación: " + nombreCliente + " - Asiento: " + numeroAsiento;
    }
}
