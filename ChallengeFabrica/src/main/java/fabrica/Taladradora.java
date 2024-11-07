package fabrica;

import java.util.EnumSet;
import java.util.Set;

public class Taladradora implements Maquina {
    private Posicion posicion;
    private Grosor grosor;



    public Taladradora(Posicion posicion, Grosor grosor) {
        if (!posicionesValidas.contains(posicion)) {
            throw new IllegalArgumentException("Posición inválida: " + posicion);
        }
    }


    private boolean esLijaFina(int grosor) {
        return grosor == 1;
    }

    private void eliminarLijasFinas(Cuadro cuadro) {
        int grosorLijaNorte = cuadro.getGrosorLijaNorte();
        int grosorLijaSur = cuadro.getGrosorLijaSur();
        int grosorLijaEste = cuadro.getGrosorLijaEste();
        int grosorLijaOeste = cuadro.getGrosorLijaOeste();

        if (esLijaFina(grosorLijaNorte)) {
            cuadro.setGrosorLijaNorte(0);
        }
        if (esLijaFina(grosorLijaEste)) {
            cuadro.setGrosorLijaEste(0);
        }

        if (esLijaFina(grosorLijaSur)) {
            cuadro.setGrosorLijaSur(0);
        }

        if (esLijaFina(grosorLijaOeste)) {
            cuadro.setGrosorLijaSur(0);
        }
    }

    @Override
    public void actua(Pieza pieza) {
        // Obtiene el cuadro en la posición de la pieza
        Cuadro cuadro = pieza.getCuadro(posicion);

        if (grosor == Grosor.Grueso) {
            // Obtiene la lista de lijas en el cuadro
            eliminarLijasFinas(cuadro);
        }


        int grosorAsNumber = Maquina.getGrosorAsNum(grosor);


        // Obtener el estado actual de la taladradora en el cuadro
        int grosorTaladradoraActual = cuadro.getGrosorTaladradora();

        // Si el grosor actual es mayor que el existente o la taladradora está vacía
        if (grosorAsNumber > grosorTaladradoraActual) {
            cuadro.setGrosorTaladradora(grosorAsNumber);
        }

    }


}
