package PlaylistInteligente;

public class Cancion {
    private final String nombre; // Campo final
    private final String artista; // Campo final
    private final int duracion; // Campo final

    // Constructor
    public Cancion(String nombre, String artista, int duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duracion;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    // Método para mostrar la información de la canción
    @Override
    public String toString() {
        return nombre + " - " + artista + " (" + duracion + " segundos)";
    }
}