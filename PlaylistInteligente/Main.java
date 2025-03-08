package PlaylistInteligente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Playlist playlist = new Playlist();
            int opcion;
            
            do {
                System.out.println("\n--- DAVE'S PLAYLIST ---");
                System.out.println("1. Agregar canción");
                System.out.println("2. Mostrar canciones");
                System.out.println("3. Eliminar canción");
                System.out.println("4. Reproducir / Pausar");
                System.out.println("5. Reproducir siguiente canción");
                System.out.println("6. Reproducir canción anterior");
                System.out.println("7. Ordenar canciones por:");
                System.out.println("   1. Artista");
                System.out.println("   2. Orden alfabético");
                System.out.println("8. Reproducir en orden aleatorio");
                System.out.println("9. Salir del reproductor");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nombre de la canción: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Artista: ");
                        String artista = scanner.nextLine();
                        playlist.agregarCancion(new Cancion(nombre, artista));
                    }
                        
                    case 2 -> playlist.mostrarPlaylist();
                        
                    case 3 -> {
                        System.out.print("Número de la canción a eliminar: ");
                        int numero = scanner.nextInt();
                        playlist.eliminarCancion(numero);
                    }
                        
                    case 4 -> playlist.reproducirPausa();
                        
                    case 5 -> playlist.reproducirSiguiente();
                        
                    case 6 -> playlist.reproducirAnterior();
                        
                    case 7 -> {
                        System.out.println("1. Artista");
                        System.out.println("2. Orden alfabético");
                        System.out.print("Seleccione una opción: ");
                        int orden = scanner.nextInt();
                        switch (orden) {
                            case 1 -> playlist.ordenarPorArtista();
                            case 2 -> playlist.ordenarPorNombre();
                            default -> System.out.println("Opción no válida.");
                        }
                    }
                        
                    case 8 -> playlist.reproducirAleatorio();
                        
                    case 9 -> System.out.println("Saliendo del reproductor...");
                        
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 9);
        }
    }
}