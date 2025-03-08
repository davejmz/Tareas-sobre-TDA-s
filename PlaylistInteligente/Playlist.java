package PlaylistInteligente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Playlist {
    private final ArrayList<Cancion> canciones;
    private int indiceActual;
    private boolean reproduciendo;

    public Playlist() {
        canciones = new ArrayList<>();
        indiceActual = 0;
        reproduciendo = false;
    }

    //Agregar una canción
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    //Eliminar una canción por número
    public void eliminarCancion(int numero) {
        if (numero >= 1 && numero <= canciones.size()) {
            canciones.remove(numero - 1);
        }
    }

    //Reproducir o pausar
    public void reproducirPausa() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        reproduciendo = !reproduciendo;
        System.out.println(reproduciendo ? "Reproduciendo: " + canciones.get(indiceActual) : "Pausada.");
    }

    //Reproducir la siguiente canción
    public void reproducirSiguiente() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        indiceActual = (indiceActual + 1) % canciones.size();
        System.out.println("Reproduciendo: " + canciones.get(indiceActual));
    }

    // Reproducir la canción anterior
    public void reproducirAnterior() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        indiceActual = (indiceActual - 1 + canciones.size()) % canciones.size();
        System.out.println("Reproduciendo: " + canciones.get(indiceActual));
    }

    //Ordenar por artista
    public void ordenarPorArtista() {
        Collections.sort(canciones, Comparator.comparing(Cancion::getArtista));
    }

    //Ordenar por nombre (orden alfabético)
    public void ordenarPorNombre() {
        Collections.sort(canciones, Comparator.comparing(Cancion::getNombre));
    }

    //Reproducir en orden aleatorio
    public void reproducirAleatorio() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        ArrayList<Cancion> copia = new ArrayList<>(canciones);
        Collections.shuffle(copia, new Random());
        System.out.println("Reproduciendo en orden aleatorio:");
        for (Cancion cancion : copia) {
            System.out.println("Reproduciendo: " + cancion);
        }
    }

    //Mostrar la playlist
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