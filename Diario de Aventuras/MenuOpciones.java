import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOpciones {
    public static void main(String[] args) {
        DiarioAventurero diario = new DiarioAventurero();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("--- Menú del Aventurero ---");
                System.out.println("1. Registrar Misión");
                System.out.println("2. Eliminar Misión");
                System.out.println("3. Mostrar Misiones");
                System.out.println("4. Buscar Misión");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); //Acá limpiamos el buffer

                //Usamos la sintaxis moderna de switch
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nombre de la misión: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Descripción: ");
                        String descripcion = scanner.nextLine();

                        int nivel = 0;
                        boolean entradaValida = false;
                        while (!entradaValida) {
                            System.out.print("Nivel de dificultad (1: Fácil, 2: Medio, 3: Difícil): ");
                            try {
                                nivel = scanner.nextInt();
                                if (nivel >= 1 && nivel <= 3) {
                                    entradaValida = true;
                                } else {
                                    System.out.println("Error: Debes ingresar un número entre 1 y 3. Intenta de nuevo.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Debes ingresar un número. Intenta de nuevo.");
                                scanner.nextLine(); //Limpiamos el buffer
                            }
                        }
                        scanner.nextLine(); //Limpiamos el buffer después de nextInt()

                        String nivelTexto = switch (nivel) {
                            case 1 -> "Fácil";
                            case 2 -> "Medio";
                            case 3 -> "Difícil";
                            default -> "Desconocido";
                        };

                        diario.registrarMision(nombre, descripcion, nivelTexto);
                    }
                    case 2 -> {
                        diario.mostrarMisionesConNumero();
                        if (!diario.estaVacio()) {
                            System.out.print("Seleccione el número de la misión que desea eliminar: ");
                            try {
                                int numeroMision = scanner.nextInt();
                                scanner.nextLine(); //Limpiamos el buffer
                                diario.eliminarMisionPorNumero(numeroMision);
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Debes ingresar un número.");
                                scanner.nextLine(); //Limpiamos el buffer
                            }
                        }
                    }
                    case 3 -> diario.mostrarMisionesConNumero();
                    case 4 -> {
                        System.out.print("Nombre de la misión a buscar: ");
                        String nombreBusqueda = scanner.nextLine();
                        diario.buscarMision(nombreBusqueda);
                    }
                    case 5 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } while (opcion != 5);
        } //Y el Scanner se cierra automáticamente aquí
    }
}