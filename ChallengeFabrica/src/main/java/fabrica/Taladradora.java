package fabrica;

import java.util.EnumSet;
import java.util.Set;

/// La clase `Taladradora` representa una máquina taladradora
public class Taladradora implements Maquina {
    private Posicion posicion;
    private Grosor grosor;



    public Taladradora(Posicion posicion, Grosor grosor) {
        if (!posicionesValidas.contains(posicion)) {
            throw new IllegalArgumentException("Posición inválida: " + posicion);
        }

        this.posicion = posicion;
        this.grosor = grosor;
    }

    ///Devuelve true si el `grosor` es 1
    ///@param grosor grosor
    private boolean esGrosorFino(int grosor) {
        return grosor == 1;
    }
    ///Dado un cuadro, elimina las lijas sin importar la orientación siempre y cuando haya lijas finas.
    /// @param cuadro cuadro del que se eliminan las lijas finas.
    private void eliminarLijasFinas(Cuadro cuadro) {
        int grosorLijaNorte = cuadro.getGrosorLijaNorte();
        int grosorLijaSur = cuadro.getGrosorLijaSur();
        int grosorLijaEste = cuadro.getGrosorLijaEste();
        int grosorLijaOeste = cuadro.getGrosorLijaOeste();

        if (esGrosorFino(grosorLijaNorte)) {
            cuadro.setGrosorLijaNorte(0);
        }
        if (esGrosorFino(grosorLijaEste)) {
            cuadro.setGrosorLijaEste(0);
        }

        if (esGrosorFino(grosorLijaSur)) {
            cuadro.setGrosorLijaSur(0);
        }

        if (esGrosorFino(grosorLijaOeste)) {
            cuadro.setGrosorLijaSur(0);
        }
    }

    ///Añade la marca a la pieza, para ello:
    /// 1. Elimina cualquier lija fina en el cuadro si la taladro es grueso.
    /// 1. Actualiza el grosor de la taladradora en el cuadro, en caso de tener que hacerlo
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
