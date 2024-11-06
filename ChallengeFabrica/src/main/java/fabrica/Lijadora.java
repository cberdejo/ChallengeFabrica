package fabrica;

<<<<<<< HEAD
import java.util.*;
=======
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

>>>>>>> 8694006cf6d073d205fd86e316ab9967b46c092b

public class Lijadora implements Maquina {

    private Grosor grosor;
    private OrLija orLija;
    private Posicion posicion;

    static Set<Posicion> posicionesValidas = EnumSet.of(
            Posicion.IzSu,
            Posicion.IzCe,
            Posicion.IzIn,
            Posicion.CeSu,
            Posicion.CeCe
<<<<<<< HEAD
=======


>>>>>>> 8694006cf6d073d205fd86e316ab9967b46c092b
    );

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
            String taladroActual = cuadro.getTaladradora();

            // Comprobar el grosor del taladro actual
            int grosorTaladroActual = 0;
            if (taladroActual.matches("TL([1-3])")) {
                grosorTaladroActual = Integer.parseInt(taladroActual.substring(2)); // Obtener el grosor del taladro
            }

            // Verificar si hay un taladro grueso
            if (grosorTaladroActual == 3) {
                // Si hay un taladro grueso, la lija fina no se coloca
                return;
            }
        }

        // Obtener el conjunto de lijas en el cuadro
        Set<String> lijas = new HashSet<>(cuadro.getLijas());


        for (String lijaActual : lijas) {
            // Comprobar si ya hay una lija en la posición deseada
            String orientacionExistente = lijaActual.substring(1, 2);
            int grosorExistente = Integer.parseInt(lijaActual.substring(2));

            // Comprobar si la orientación de la nueva lija es la misma que la existente
            if (orientacionExistente.equals(getOrientacion())) {
                // Si el grosor de la nueva lija es mayor que el existente, reemplazarla
                if (grosorLijadora > grosorExistente) {
                    cuadro.setLija("L" + getOrientacion() + grosorLijadora);
                    System.out.println("Lija colocada o reemplazada: " + "L" + getOrientacion() + grosorLijadora);
                }
            }
        }

        // Si no se encontró ninguna lija con la misma orientación, añadir la nueva lija
        cuadro.addLija("L" + getOrientacion() + grosorLijadora);
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

