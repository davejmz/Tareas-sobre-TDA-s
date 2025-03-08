import java.util.Stack;

public class DiarioAventurero {
    private final Stack<Mision> pilaMisiones;

    public DiarioAventurero() {
        pilaMisiones = new Stack<>();
    }

    //Registramos misión 
    public void registrarMision(String nombre, String descripcion, String nivel) {
        Mision nuevaMision = new Mision(nombre, descripcion, nivel);
        pilaMisiones.push(nuevaMision);
        System.out.println("Misión registrada: " + nombre);
    }

    // Mostrar misiones con un número de identificación
    public void mostrarMisionesConNumero() {
        if (pilaMisiones.isEmpty()) {
            System.out.println("No hay misiones registradas.");
        } else {
            System.out.println("Misiones registradas:");
            int contador = 1;
            for (Mision mision : pilaMisiones) {
                System.out.println(contador + ". " + mision);
                contador++;
            }
        }
    }

    //Acá podemos eliminar una misión específica por su número
    public void eliminarMisionPorNumero(int numero) {
        if (numero < 1 || numero > pilaMisiones.size()) {
            System.out.println("Número de misión inválido.");
        } else {
            //Convertimos el número a un índice (restamos 1 porque los índices comienzan en 0)
            int indice = pilaMisiones.size() - numero;
            Mision misionEliminada = pilaMisiones.remove(indice);
            System.out.println("Misión eliminada: " + misionEliminada.obtenerNombreDeMision());
        }
    }

    //Verificamos si la pila de misiones está vacía
    public boolean estaVacio() {
        return pilaMisiones.isEmpty();
    }

    //Buscamos una misión por nombre o número
    public void buscarMision(String nombre) {
        boolean encontrada = false;
        for (Mision mision : pilaMisiones) {
            if (mision.obtenerNombreDeMision().equals(nombre)) {
                System.out.println("Misión encontrada: " + mision);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Misión no encontrada: " + nombre);
        }
    }
}
