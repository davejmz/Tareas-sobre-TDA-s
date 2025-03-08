package ReservacionesParaUnTeatro;

public class Main {
    public static void main(String[] args) {
        //Crear un gestor de boletos con 100 asientos
        GestorBoletos gestor = new GestorBoletos(100);

        //Mostrar menú de interacción
        System.out.println("Bienvenido a DAVE'S THEATRE");
        System.out.println("El teatro cuenta con 100 asientos, enumerados del 1 al 100.");
        gestor.menu();
    }
}
