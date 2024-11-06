package fabrica;


import java.util.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;



public class Lijadora implements Maquina {

    private Grosor grosor;
    private OrLija orLija;
    private Posicion posicion;

    static Set<Posicion> posicionesValidas = EnumSet.of(
            Posicion.IzSu,
            Posicion.IzCe,
            Posicion.IzIn,
            Posicion.CeSu,
            Posicion.CeCe);

    public Lijadora(Posicion posicion,OrLija or,Grosor grosor) {
        if (!posicionesValidas.contains(posicion)) {
            throw new IllegalArgumentException("Posición inválida: " + posicion);
        }
    }


    @Override
    public void actua(Pieza pieza) {
        // Obtener el cuadro en la posición de la pieza
        Cuadro cuadro = pieza.getCuadro(posicion);

        // Determinar el grosor de la lijadora como un valor entero
        int grosorLijadora;
        switch (this.grosor) {
            case Grueso:
                grosorLijadora = 3;
                break;
            case Medio:
                grosorLijadora = 2;
                break;
            case Fino:
            default:
                grosorLijadora = 1;
                break;
        }

        // Comprobar si la lija que se va a colocar es de grosor Fino
        if (this.grosor == Grosor.Fino) {
            // Obtener el estado actual del taladro
            int grosorTaladroActual = cuadro.getGrosorTaladradora();



            // Verificar si hay un taladro grueso
            if (grosorTaladroActual == 3) {
                // Si hay un taladro grueso, la lija fina no se coloca
                return;
            }
        }


        int grosor = 0;
                switch (this.grosor) {
            case Grueso:
                grosor = 3;
                break;
            case Medio:
                grosor = 2;
                break;
            case Fino:
            default:
                grosor = 1;
                break;
        }
        // Obtener el conjunto de lijas en el cuadro
        switch (orLija) {
            case Norte:
                if (cuadro.getGrosorLijaByOrLija(orLija) == 0) {

                    //añadir
                }else if (cuadro.getGrosorLijaByOrLija(orLija) < grosor ) {
                    //eliminar lija con menor grosor
                    //añadir nueva lija

                }
                break;
            case Sur:
                break;
            case Este:
                break;
            case Oeste:
                break;
            default:
        }

        
    }


    private String getOrientacion() {
        switch (orLija) {
            case Norte:
                return "N";
            case Sur:
                return "S";
            case Este:
                return "E";
            case Oeste:
                return "O";
            default:
                return "Orientacion no valida";
        }
    }
}

