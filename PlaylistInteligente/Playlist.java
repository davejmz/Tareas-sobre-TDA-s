package PlaylistInteligente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Playlist {
    private final ArrayList<Cancion> canciones; // Campo final
    private int indiceActual;

    // Constructor
    public Playlist() {
        canciones = new ArrayList<>();
        indiceActual = 0;
    }

    // Agregar una canción
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    // Eliminar una canción por número
    public void eliminarCancion(int numero) {
        if (numero >= 1 && numero <= canciones.size()) {
            canciones.remove(numero - 1);
            System.out.println("Canción eliminada.");
        } else {
            System.out.println("Número de canción inválido.");
        }
    }

    // Reproducir la siguiente canción
    public void reproducirSiguiente() {
        if (indiceActual < canciones.size()) {
            System.out.println("Reproduciendo: " + canciones.get(indiceActual));
            indiceActual++;
        } else {
            System.out.println("No hay más canciones en la playlist.");
        }
    }

    // Ordenar por duración (ascendente)
    public void ordenarPorDuracion() {
        Collections.sort(canciones, Comparator.comparingInt(Cancion::getDuracion));
        System.out.println("Playlist ordenada por duración.");
    }

    // Ordenar por artista (alfabético)
    public void ordenarPorArtista() {
        Collections.sort(canciones, Comparator.comparing(Cancion::getArtista));
        System.out.println("Playlist ordenada por artista.");
    }

    // Reproducir en orden aleatorio
    public void reproducirAleatorio() {
        ArrayList<Cancion> copia = new ArrayList<>(canciones);
        Collections.shuffle(copia, new Random());
        System.out.println("Reproduciendo en orden aleatorio:");
        for (Cancion cancion : copia) {
            System.out.println("Reproduciendo: " + cancion);
        }
    }

    // Mostrar todas las canciones en la playlist
    public void mostrarPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
        } else {
            System.out.println("Playlist actual:");
            for (int i = 0; i < canciones.size(); i++) {
                System.out.println((i + 1) + ". " + canciones.get(i));
            }
        }
    }
}