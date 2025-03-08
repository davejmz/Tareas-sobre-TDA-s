//Archivo: Mision.java
public class Mision {
    private final String nombre;
    private final String descripcion;
    private final String nivel;

    //Constructor
    public Mision(String nombre, String descripcion, String nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    //Métodos para obtener los atributos
    public String obtenerNombreDeMision() {
        return nombre;
    }

    public String obtenerDescripcionDeMision() {
        return descripcion;
    }

    public String obtenerNivelDeDificultad() {
        return nivel;
    }

    //Método para mostrar la misión como una cadena de texto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Descripción: " + descripcion + ", Nivel: " + nivel;
    }
}