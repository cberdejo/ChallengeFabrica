import fabrica.*;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Pieza y Cuadro
        Pieza pieza = new Pieza();

        // Inicializar cada cuadro en la pieza con valores de ejemplo:
        // Algunos grosores estarán entre 1 y 3, y otros se dejarán en 0 para simular ausencia de marca.
        for (int i = 0; i < 9; i++) {
            pieza.cuadros[i] = new Cuadro();

            // Establecer algunos valores de grosor, dejando otros en 0.
            pieza.cuadros[i].setGrosorLijaNorte(i % 2 == 0 ? 1 : 0); // Ejemplo de asignación condicional
            pieza.cuadros[i].setGrosorLijaEste(i % 3 == 0 ? 2 : 0);
            pieza.cuadros[i].setGrosorLijaSur(i % 4 == 0 ? 3 : 0);
            pieza.cuadros[i].setGrosorFresadoraVertical(i == 4 ? 2 : 0);
            pieza.cuadros[i].setGrosorFresadoraDiagonalDerecha(i % 5 == 0 ? 1 : 0);
            pieza.cuadros[i].setGrosorTaladradora(i % 2 == 1 ? 3 : 0);
        }

        // Mostrar el estado inicial de la pieza
        System.out.println("Estado inicial de la pieza:");
        System.out.println(pieza);

        // Realizar rotación en sentido horario y mostrar el estado
        pieza.rotar(Sentido.Horario);
        System.out.println("\nDespués de una rotación en sentido horario:");
        System.out.println(pieza);

        // Realizar rotación en sentido antihorario y mostrar el estado
        pieza.rotar(Sentido.Antihorario);
        System.out.println("\nDespués de una rotación en sentido antihorario:");
        System.out.println(pieza);
    }
}
