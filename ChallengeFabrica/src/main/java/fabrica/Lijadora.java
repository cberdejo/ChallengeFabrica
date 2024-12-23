package fabrica;
import java.util.EnumSet;
import java.util.Set;



 /// La clase Lijadora representa una máquina lijadora utilizada en una fábrica
 /// para modificar los cuadros de una pieza mediante el uso de lijas. La lijadora
 /// puede tener distintas orientaciones (Norte, Sur) y se coloca en las posiciones
 /// específicas de la pieza.
 ///
 /// Implementa la interfaz Maquina, lo que permite que interactúe con el sistema
 /// de procesamiento de piezas.

public class Lijadora implements Maquina {

    private Grosor grosor;
    private OrLija orLija;
    private Posicion posicion;


    Set<OrLija> orientacionesInicialesValidas = EnumSet.of(
          OrLija.Sur,
          OrLija.Norte
    );


    /// Constructor de la clase lijadora
    /// @param posicion La posicion en la que se coloca la lija
    /// @param orLija La orientacion de la lija
    /// @param grosor El grosor de la lija
    /// @throws IllegalArgumentException Si la posicion u orientación es inválida
    public Lijadora(Posicion posicion,OrLija orLija,Grosor grosor) {
        if (!posicionesValidas.contains(posicion) || !orientacionesInicialesValidas.contains(orLija) ) {
            throw new IllegalArgumentException("Posición/orientación inválida");
        }

        this.posicion = posicion;
        this.orLija = orLija;
        this.grosor = grosor;
    }

    /// Lijadora actua sobre la pieza
    /// @param pieza La pieza sobre la que se actua
    @Override
    public void actua(Pieza pieza) {
        // Obtener el cuadro en la posición de la pieza
        Cuadro cuadro = pieza.getCuadro(posicion);
        // Metodo para marcar la lijadora
        nuevaLijadora(cuadro);
    }

    /// Nueva lija en un cuadro
    /// @param cuadro Cuadro sobre el que actuara la lijadora
    private void nuevaLijadora(Cuadro cuadro){

        // Determina el grosor basado en el tipo de grosor (Fino, Medio, Grueso)
        int grosorNuevaLijadora = Maquina.getGrosorAsNum(grosor);;


        if (!(cuadro.getGrosorTaladradora() == 3 && grosorNuevaLijadora == 1)) {
            // Actualizacion de las lijas en funcion de su orientacion
            switch (orLija) {
                case Norte:
                    if (cuadro.getGrosorLijaNorte() < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaNorte(grosorNuevaLijadora); // Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
                case Sur:
                    if (cuadro.getGrosorLijaSur() < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaSur(grosorNuevaLijadora); // Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
                case Este:
                    if (cuadro.getGrosorLijaEste() < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaEste(grosorNuevaLijadora); // Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
                case Oeste:
                    if (cuadro.getGrosorLijaOeste() < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaOeste(grosorNuevaLijadora); // Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
            }
        }
    }
}

