package fabrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fabrica {
    private List<Maquina> maquinas;
    private static Random alea = new Random();

    public Fabrica() {
        maquinas = new ArrayList<>();
    }
<<<<<<< HEAD

    //public static Fabrica aleatorio(int n){
    //    //To do
    //}
=======
    public Fabrica(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }
>>>>>>> d81c502a82fdd58ca34f91fad45d98a7a8828edf

    ///Crea	una	`Fabrica` aleatoria con el número	de máquinas	pasado como	argumento. Cada tipo de máquina	tiene la misma probabilidad de aparecer en la fábrica resultante.
    ///
    ///  **Algunas consideraciones:**
    /// - No tiene sentido	girar una pieza	en un sentido para inmediatamente después girarla en sentido	contrario.
    /// - Giros	al principio de	la fábrica no tienen sentido.
    /// @param n	El número	de máquinas	de la fábrica	resultante.
    /// @return Una	fábrica	aleatoria.
    public static Fabrica aleatorio(int n) {
        List<Maquina> maquinas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Maquina nuevaMaquina;

            do {
                int tipoMaquina = alea.nextInt(4);
                nuevaMaquina = switch (tipoMaquina) {
                    case 0 -> new Fresadora(
                            Grosor.values()[alea.nextInt(Grosor.values().length)],
                            OrFresa.values()[alea.nextInt(OrFresa.values().length)],
                            Posicion.values()[alea.nextInt(Posicion.values().length)]
                    );
                    case 1 -> new Lijadora(
                            Grosor.values()[alea.nextInt(Grosor.values().length)],
                            OrLija.values()[alea.nextInt(OrLija.values().length)],
                            Posicion.values()[alea.nextInt(Posicion.values().length)]
                    );
                    case 2 -> {
                        Sentido sentido = Sentido.values()[alea.nextInt(Sentido.values().length)];
                        yield new Rotadora(sentido);
                    }
                    case 3 -> new Taladradora(
                            Posicion.values()[alea.nextInt(Posicion.values().length)],
                            Grosor.values()[alea.nextInt(Grosor.values().length)]
                    );
                    default -> null;
                };
            } while (nuevaMaquina instanceof Rotadora && rotadoraIncorrecta(maquinas, nuevaMaquina));

            maquinas.add(nuevaMaquina);
        }

        return new Fabrica(maquinas);
    }

    ///Comprueba que una `Rotadora` es incorrecta para insertarse en el método `aleatorio(int n)`.
    ///
    /// **Decimos que una `Rotadora` es incorrecta si:**
    ///- Si la `Rotadora` es la primera `Maquina` que se intenta insertar.
    ///- Si la `Maquina` inmediatamente anterior es una `Rotadora` y la `Maquina` actual es una `Rotadora` y el sentido de la `Rotadora` inmediatamente anterior es *opuesto* al sentido de la `Rotadora` actual.
    private static boolean rotadoraIncorrecta(List<Maquina> maquinas, Maquina nuevaMaquina) {
        if (maquinas.isEmpty() && nuevaMaquina instanceof Rotadora) {
            return true; // Evitar que sea la primera máquina.
        }

        if (!maquinas.isEmpty() && nuevaMaquina instanceof Rotadora) {
            Maquina anterior = maquinas.getLast();
            if (anterior instanceof Rotadora) {
                return ((Rotadora) anterior).getSentido() != ((Rotadora) nuevaMaquina).getSentido();
            }
        }

        return false;
    }
    public void marca(Pieza pieza){
        maquinas.forEach(maquina -> maquina.actua(pieza));
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void addMaquina(Maquina maquina){
        maquinas.add(maquina);
    }
}
