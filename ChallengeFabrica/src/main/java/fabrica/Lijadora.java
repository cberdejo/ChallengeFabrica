package fabrica;
import java.util.EnumSet;
import java.util.Set;



public class Lijadora implements Maquina {

    private Grosor grosor;
    private OrLija orLija;
    private Posicion posicion;

    /// Conjunto d e posiciones validas para las lijas
    static Set<Posicion> posicionesValidas = EnumSet.of(
            Posicion.IzSu,
            Posicion.IzCe,
            Posicion.IzIn,
            Posicion.CeSu,
            Posicion.CeCe);

    /// Constructor de la clase lijadora
    /// @param posicion La posicion en la que se coloca la lija
    /// @param orLija La orientacion de la lija
    /// @param grosor El grosor de la lija
    /// @throws IllegalArgumentException Si la posicion es invalida
    public Lijadora(Posicion posicion,OrLija orLija,Grosor grosor) {
        if (!posicionesValidas.contains(posicion)) {
            throw new IllegalArgumentException("Posición inválida: " + posicion);
        }
        this.posicion = posicion;
        this.orLija = orLija;
        this.grosor = grosor;
    }


    /// Lijadora actua sobre la pieza
    /// @param pieza La pieza sobre la que se actua
    @Override
    public void actua(Pieza pieza) {
        /// Obtener el cuadro en la posición de la pieza
        Cuadro cuadro = pieza.getCuadro(posicion);
        /// Metodo para aplicar la lijadora
        nuevaLijadora(cuadro, orLija);
        
    }

    /// Nueva lija en un cuadro
    /// @param cuadro Cuadro sobre el que actuara la lijadora
    /// @param orLija La orientacion de la lija
    private void nuevaLijadora(Cuadro cuadro, OrLija orLija){
        int grosorNuevaLijadora;

        /// Determina el grosor basado en el tipo de grosor (Fino, Medio, Grueso)
        switch (this.grosor) {
            case Grueso:
                grosorNuevaLijadora = 3;
                break;
            case Medio:
                grosorNuevaLijadora = 2;
                break;
            case Fino:
            default:
                grosorNuevaLijadora = 1;
                break;
        }

        if (cuadro.getGrosorTaladradora() == 3 && grosorNuevaLijadora == 1) {
            return; /// Si hay una taladradora no se puede poner una nueva lija fina
        } else {
            /// Actualizacion de las lijas en funcion de su orientacion
            switch (orLija) {
                case Norte:
                    int grosorLijaN = cuadro.getGrosorLijaNorte();
                    if (grosorLijaN == 0) {
                        cuadro.setGrosorLijaNorte(grosorNuevaLijadora); /// Añadir nueva lija si no existe
                    } else if (grosorLijaN < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaNorte(grosorNuevaLijadora); /// Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
                case Sur:
                    int grosorLijaS = cuadro.getGrosorLijaSur();
                    if (grosorLijaS == 0) {
                        cuadro.setGrosorLijaSur(grosorNuevaLijadora); /// Añadir nueva lija si no existe
                    } else if (grosorLijaS < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaSur(grosorNuevaLijadora); /// Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
                case Este:
                    int grosorLijaE = cuadro.getGrosorLijaEste();
                    if (grosorLijaE == 0) {
                        cuadro.setGrosorLijaEste(grosorNuevaLijadora); /// Añadir nueva lija si no existe
                    } else if (grosorLijaE < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaEste(grosorNuevaLijadora); /// Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
                case Oeste:
                    int grosorLijaO = cuadro.getGrosorLijaOeste();
                    if (grosorLijaO == 0) {
                        cuadro.setGrosorLijaOeste(grosorNuevaLijadora); /// Añadir nueva lija si no existe
                    } else if (grosorLijaO < grosorNuevaLijadora) {
                        cuadro.setGrosorLijaOeste(grosorNuevaLijadora); /// Reemplazar si el grosor de la nueva lija es mayor
                    }
                    break;
            }
        }
    }
}

