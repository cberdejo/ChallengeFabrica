package fabrica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Fabrica {
    private List<Maquina> maquinas;
    private static final Random alea = new Random();

    public Fabrica() {
        maquinas = new LinkedList<>();
    }
    public Fabrica(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    ///Crea	una	`Fabrica` aleatoria con el número	de máquinas	pasado como	argumento. Cada tipo de máquina	tiene la misma probabilidad de aparecer en la fábrica resultante.
    ///
    ///  **Algunas consideraciones:**
    /// - No tiene sentido	girar una pieza	en un sentido para inmediatamente después girarla en sentido	contrario.
    /// - Giros	al principio de	la fábrica no tienen sentido.
    /// @param n	El número	de máquinas	de la fábrica	resultante.
    /// @return Una	fábrica	aleatoria.
    public static Fabrica aleatorio(int n) {
        List<Maquina> maquinas = new LinkedList<>();
        int numMaquinas =4;

        for (int i = 0; i < n; i++) {
            Maquina nuevaMaquina;

            do {
                int tipoMaquina = alea.nextInt(numMaquinas);
                nuevaMaquina = switch (tipoMaquina) {
                    case 0 -> new Fresadora(
                            Posicion.values()[alea.nextInt(Posicion.values().length)],
                            OrFresa.values()[alea.nextInt(OrFresa.values().length)],
                            Grosor.values()[alea.nextInt(Grosor.values().length)]

                            );
                    case 1 -> new Lijadora(
                            Posicion.values()[alea.nextInt(Posicion.values().length)],
                            OrLija.values()[alea.nextInt(OrLija.values().length)],
                            Grosor.values()[alea.nextInt(Grosor.values().length)]
                    );
                    case 2 -> new Rotadora(Sentido.values()[alea.nextInt(Sentido.values().length)]);

                    case 3 -> new Taladradora(
                            Posicion.values()[alea.nextInt(Posicion.values().length)],
                            Grosor.values()[alea.nextInt(Grosor.values().length)]
                    );
                    default -> null;
                };
            } while (  rotadoraIncorrecta(maquinas, nuevaMaquina));

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
        if (!(nuevaMaquina instanceof Rotadora)) {
            return false;
        }
        if (maquinas.isEmpty() ) {
            return true; // Evitar que sea la primera máquina.
        }

        Maquina anterior = maquinas.getLast();
        if (anterior instanceof Rotadora) {
            return ((Rotadora) anterior).getSentido() != ((Rotadora) nuevaMaquina).getSentido();
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
