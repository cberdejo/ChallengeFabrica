package fabrica;

public class PruebaPieza {
    public static void main(String[] args) {
        // Paso 1: Crear una pieza y configurar cuadros con valores de prueba
        Pieza pieza = new Pieza();

        // Configuramos valores en los cuadros para ver el cambio después de rotar
        for (int i = 0; i < 9; i++) {
            pieza.cuadros[i].setGrosorFresadoraVertical(i % 4);        // Valores de 0 a 3
            pieza.cuadros[i].setGrosorFresadoraHorizontal((i + 1) % 4);
            pieza.cuadros[i].setGrosorFresadoraDiagonalDerecha((i + 2) % 4);
            pieza.cuadros[i].setGrosorFresadoraDiagonalIzquierda((i + 3) % 4);
            pieza.cuadros[i].setGrosorLijaNorte(i % 4);
            pieza.cuadros[i].setGrosorLijaSur((i + 1) % 4);
            pieza.cuadros[i].setGrosorLijaEste((i + 2) % 4);
            pieza.cuadros[i].setGrosorLijaOeste((i + 3) % 4);
            pieza.cuadros[i].setGrosorTaladradora(i % 4);
        }

        // Paso 2: Imprimir el estado inicial de la pieza
        System.out.println("Estado inicial de la pieza:");
        System.out.println(pieza);

        // Paso 3: Aplicar una rotación en sentido horario y ver el resultado
        pieza.rotar(Sentido.Horario);
        System.out.println("Después de rotar en sentido horario:");
        System.out.println(pieza);

        // Paso 4: Aplicar una rotación en sentido antihorario y ver el resultado
        pieza.rotar(Sentido.Antihorario);
        System.out.println("Después de rotar en sentido antihorario:");
        System.out.println(pieza);
    }
}
