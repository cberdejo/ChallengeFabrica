package fabrica;

import java.util.EnumSet;
import java.util.Set;

///
/// La clase `Fresadora` representa una máquina fresadora utilizada en una fábrica para modificar
/// los cuadros de una pieza mediante el uso de fresas. La fresadora puede tener distintos grosores
/// y orientaciones (Vertical, Horizontal, Diagonal), y se aplica en las posiciones específicas de la pieza.
///
/// Implementa la interfaz `Maquina`, lo que permite que interactúe con el sistema de procesamiento de piezas.
///
public class Fresadora implements Maquina {

    private Grosor grosor; //< Grosor de la fresadora (Fino, Medio, Grueso)
    private OrFresa orFresa; //< Orientación de la fresadora (Vertical, Horizontal, Diagonal)
    private Posicion pos; //< Posición donde se aplica la fresadora en la pieza

    ///
    /// Constructor de la clase `Fresadora`.
    ///
    /// @param grosor El grosor de la fresadora (Fino, Medio, Grueso).
    /// @param orFresa La orientación de la fresadora (Vertical, Horizontal, Diagonal).
    /// @param pos La posición en la pieza donde se aplicará la fresadora.
    ///
    /// @throws IllegalArgumentException Si la posición proporcionada no es válida.
    ///
    public Fresadora(Grosor grosor, OrFresa orFresa, Posicion pos) {
        this.grosor = grosor;
        this.orFresa = orFresa;
        this.pos = pos;
        if (!posicionesValidas.contains(pos)) {
            throw new IllegalArgumentException("Posición inválida: " + pos);
        }
    }

    ///
    /// Conjunto de posiciones válidas para aplicar la fresadora en una pieza.
    ///
    static Set<Posicion> posicionesValidas = EnumSet.of(
            Posicion.IzSu,
            Posicion.IzCe,
            Posicion.IzIn,
            Posicion.CeSu,
            Posicion.CeCe
    );

    ///
    /// Método que realiza la acción de fresado sobre una pieza.
    ///
    /// Se verifica y aplica el grosor y orientación de la fresadora sobre el cuadro
    /// correspondiente de la pieza.
    ///
    /// @param pieza La pieza sobre la que se va a aplicar la fresadora.
    ///
    @Override
    public void actua(Pieza pieza) {
        // Obtiene el cuadro en la posición de la pieza
        Cuadro cuadro = pieza.getCuadro(pos);

        // Si ya existe una fresadora anterior en la posición, se actualiza el grosor.
        // Si no, se crea una nueva fresadora con el grosor y orientación especificados.
        nuevaFresaOActualiza(cuadro, orFresa);
    }

    ///
    /// Método privado para actualizar o agregar una fresadora en el cuadro de la pieza.
    /// Si el grosor de la fresadora existente es menor que el grosor deseado, se actualiza.
    ///
    /// @param cuadro El cuadro de la pieza donde se aplicará la fresadora.
    /// @param orFresa La orientación de la fresadora (Vertical, Diagonal).
    ///
    private void nuevaFresaOActualiza(Cuadro cuadro, OrFresa orFresa) {
        int grosorFresaDeseado;

        // Determina el grosor deseado basado en el tipo de grosor (Fino, Medio, Grueso)
        switch (this.grosor) {
            case Grueso:
                grosorFresaDeseado = 3;
                break;
            case Medio:
                grosorFresaDeseado = 2;
                break;
            case Fino:
            default:
                grosorFresaDeseado = 1;
                break;
        }

        // Comprobamos la orientación y actualizamos el grosor de la fresadora en el cuadro
        switch (orFresa) {
            case Vertical:
                int grosorFresaV = cuadro.getGrosorFresadoraVertical();
                // Si el grosor actual es menor que el deseado, se actualiza
                if (grosorFresaV < grosorFresaDeseado)
                    cuadro.setGrosorFresadoraVertical(grosorFresaDeseado);
                break;


            case Diagonal:
                int grosorFresaD = cuadro.getGrosorFresadoraDiagonalDerecha();
                // Si el grosor actual es menor que el deseado, se actualiza
                if (grosorFresaD < grosorFresaDeseado)
                    cuadro.setGrosorFresadoraDiagonalDerecha(grosorFresaDeseado);
                break;


        }
    }
}