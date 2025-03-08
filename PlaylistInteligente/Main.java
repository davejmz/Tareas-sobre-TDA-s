package PlaylistInteligente;

public class Main {
    public static void main(String[] args) {
        // Crear una playlist
        Playlist playlist = new Playlist();

        // Agregar canciones
        playlist.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        playlist.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        playlist.agregarCancion(new Cancion("Rolling in the Deep", "Adele", 228));
        playlist.agregarCancion(new Cancion("Stairway to Heaven", "Led Zeppelin", 482));

        // Mostrar playlist
        playlist.mostrarPlaylist();

        // Reproducir siguiente canción
        System.out.println("\nReproduciendo canciones:");
        playlist.reproducirSiguiente();
        playlist.reproducirSiguiente();

        // Ordenar por duración y mostrar
        playlist.ordenarPorDuracion();
        playlist.mostrarPlaylist();

        // Ordenar por artista y mostrar
        playlist.ordenarPorArtista();
        playlist.mostrarPlaylist();

        // Eliminar una canción
        System.out.println("\nEliminando la canción 2:");
        playlist.eliminarCancion(2);
        playlist.mostrarPlaylist();

        // Reproducir en orden aleatorio (bonus)
        System.out.println("\nReproducción aleatoria:");
        playlist.reproducirAleatorio();
    }
}