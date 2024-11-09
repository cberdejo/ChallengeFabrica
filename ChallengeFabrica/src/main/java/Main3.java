import fabrica.Fabrica;
import fabrica.Pieza;

public class Main3 {
    public static void main(String[] args) {
        Fabrica fabrica = Fabrica.aleatorio(10);
        Pieza pieza = new Pieza();
        fabrica.marca(pieza);
        System.out.println(pieza);
    }
}
