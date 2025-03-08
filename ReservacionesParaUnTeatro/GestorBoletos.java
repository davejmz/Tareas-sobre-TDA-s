package ReservacionesParaUnTeatro;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GestorBoletos {
    private final Queue<Reservacion> colaReservaciones;
    private final boolean[] asientosOcupados;
    private final int totalAsientos;

    public GestorBoletos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
        this.colaReservaciones = new LinkedList<>();
        this.asientosOcupados = new boolean[totalAsientos + 1];
    }

    //Método para determinar la fila del asiento
    private String determinarFila(int numeroAsiento) {
        if (numeroAsiento >= 1 && numeroAsiento <= 20) {
            return "Primera Fila";
        } else if (numeroAsiento <= 40) {
            return "Segunda Fila";
        } else if (numeroAsiento <= 60) {
            return "Tercera Fila";
        } else if (numeroAsiento <= 80) {
            return "Cuarta Fila";
        } else if (numeroAsiento <= 100) {
            return "Quinta Fila";
        } else {
            return "Asiento fuera de rango";
        }
    }

    //Registrar una nueva reservación
    public void registrarReservacion(String nombreCliente, int numeroAsiento) {
        if (numeroAsiento < 1 || numeroAsiento > totalAsientos) {
            System.out.println("Número de asiento inválido.");
            return;
        }
        if (asientosOcupados[numeroAsiento]) {
            System.out.println("El asiento " + numeroAsiento + " ya está ocupado.");
            return;
        }
        String fila = determinarFila(numeroAsiento);
        Reservacion nuevaReservacion = new Reservacion(nombreCliente, numeroAsiento);
        colaReservaciones.add(nuevaReservacion);
        asientosOcupados[numeroAsiento] = true;
        System.out.println("Reservación registrada: " + fila + ", Asiento " + numeroAsiento);
    }

    //Modificar el asiento de una reservación
    public void modificarAsiento(String nombreCliente, int nuevoAsiento) {
        for (Reservacion reservacion : colaReservaciones) {
            if (reservacion.getNombreCliente().equals(nombreCliente)) {
                if (nuevoAsiento < 1 || nuevoAsiento > totalAsientos) {
                    System.out.println("Número de asiento inválido.");
                    return;
                }
                if (asientosOcupados[nuevoAsiento]) {
                    System.out.println("El asiento " + nuevoAsiento + " ya está ocupado.");
                    return;
                }
                asientosOcupados[reservacion.getNumeroAsiento()] = false;
                reservacion.setNumeroAsiento(nuevoAsiento);
                asientosOcupados[nuevoAsiento] = true;
                System.out.println("Cambio de asiento aceptado: " + reservacion);
                return;
            }
        }
        System.out.println("No se encontró una reservación a nombre de " + nombreCliente);
    }

    //Cancelar una reservación
    public void cancelarReservacion(String nombreCliente) {
        for (Reservacion reservacion : colaReservaciones) {
            if (reservacion.getNombreCliente().equals(nombreCliente)) {
                colaReservaciones.remove(reservacion);
                asientosOcupados[reservacion.getNumeroAsiento()] = false;
                System.out.println("Reservación cancelada: " + reservacion);
                return;
            }
        }
        System.out.println("No se encontró una reservación a nombre de " + nombreCliente);
    }

    //Verificar si un asiento está ocupado
    public boolean verificarAsientoOcupado(int numeroAsiento) {
        if (numeroAsiento < 1 || numeroAsiento > totalAsientos) {
            System.out.println("Número de asiento inválido.");
            return false;
        }
        return asientosOcupados[numeroAsiento];
    }

    //Mostrar todas las reservaciones en orden de llegada
    public void mostrarReservaciones() {
        if (colaReservaciones.isEmpty()) {
            System.out.println("No hay reservaciones registradas.");
            return;
        }
        System.out.println("Reservaciones actuales:");
        for (Reservacion reservacion : colaReservaciones) {
            System.out.println(reservacion);
        }
    }

    //Bonus: Asignar automáticamente el mejor asiento disponible
    public int asignarMejorAsiento(String nombreCliente) {
        //Priorizar asientos de la primera fila (1-20)
        for (int i = 1; i <= 20; i++) {
            if (!asientosOcupados[i]) {
                registrarReservacion(nombreCliente, i);
                return i;
            }
        }
        //Si no hay asientos en la primera fila, buscar en el resto
        for (int i = 21; i <= totalAsientos; i++) {
            if (!asientosOcupados[i]) {
                registrarReservacion(nombreCliente, i);
                return i;
            }
        }
        System.out.println("No hay asientos disponibles.");
        return -1;
    }

    //Método para interactuar con el usuario
    public void menu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- DAVE'S THEATRE ---");
                System.out.println("1. Nueva reservación");
                System.out.println("2. Modificar asiento de reservación");
                System.out.println("3. Cancelar/Eliminar reservación");
                System.out.println("4. Verificar si un asiento está ocupado");
                System.out.println("5. Mostrar lista de reservaciones");
                System.out.println("6. Asignar mejor asiento disponible (Bonus)");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el número de asiento: ");
                        int asiento = scanner.nextInt();
                        registrarReservacion(nombre, asiento);
                    }
                    case 2 -> {
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo número de asiento: ");
                        int asiento = scanner.nextInt();
                        modificarAsiento(nombre, asiento);
                    }
                    case 3 -> {
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        cancelarReservacion(nombre);
                    }
                    case 4 -> {
                        System.out.print("Ingrese el número de asiento a verificar: ");
                        int asiento = scanner.nextInt();
                        System.out.println("¿El asiento está ocupado? " + verificarAsientoOcupado(asiento));
                    }
                    case 5 -> mostrarReservaciones();
                    case 6 -> {
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        int mejorAsiento = asignarMejorAsiento(nombre);
                        if (mejorAsiento != -1) {
                            System.out.println("Asiento asignado: " + mejorAsiento);
                        }
                    }
                    case 7 -> {
                        System.out.println("Saliendo del sistema...");
                        return;
                    }
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
        }
    }
}
