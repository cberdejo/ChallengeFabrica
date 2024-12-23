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

   /// Devuelve un valor númerico que representa el grosor:
   /// 1. Grueso -> 3
   /// 1. Medio -> 2
   /// 1. Fino -> 1
   /// @param  grosor
   /// @return  valor númerico del grosor
    static int getGrosorAsNum(Grosor grosor) {
        return switch (grosor) {
            case Grueso -> 3;
            case Medio -> 2;
            default -> 1;
        };
    }

    void actua(Pieza pieza);
}
