package fabrica;

import java.util.EnumSet;
import java.util.Set;

public interface Maquina {
   Set<Posicion> posicionesValidas = EnumSet.of(
            Posicion.IzSu,
            Posicion.IzCe,
            Posicion.IzIn,
            Posicion.CeSu,
            Posicion.CeCe
    );

    static int getGrosorAsNum(Grosor grosor) {
        return switch (grosor) {
            case Grueso -> 3;
            case Medio -> 2;
            default -> 1;
        };
    }

    void actua(Pieza pieza);
}
