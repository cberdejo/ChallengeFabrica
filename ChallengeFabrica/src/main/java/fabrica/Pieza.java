package fabrica;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

///  Clase que representa una pieza.
public class Pieza {
    private static Map<Posicion, Integer> posicionMap = Map.of(
            Posicion.IzSu, 0,
            Posicion.CeSu, 1,
            Posicion.DeSu, 2,
            Posicion.IzCe, 3,
            Posicion.CeCe, 4,
            Posicion.DeCe, 5,
            Posicion.IzIn, 6,
            Posicion.CeIn, 7,
            Posicion.DeIn, 8
    );
    public List<Cuadro> cuadros;

    public Pieza() {
       cuadros = List.of(
               new Cuadro(),
               new Cuadro(),
               new Cuadro(),
               new Cuadro(),
               new Cuadro(),
               new Cuadro(),
               new Cuadro(),
               new Cuadro(),
               new Cuadro()
       );
    }

    ///Devuelve un cuadro dada una posición
    /// @param posicion
    /// @return Cuadro en la posición pasada por parámetro
    public Cuadro getCuadro(Posicion posicion) {
       return cuadros.get(posicionMap.get(posicion));
    }

    ///Rota los cuadros de la pieza según el sentido indicado.
    /// @param sentido
    public void rotar(Sentido sentido) {
        cuadros = sentido == Sentido.Antihorario ?
        List.of(
                getCuadro(Posicion.DeSu),
                getCuadro(Posicion.DeCe),
                getCuadro(Posicion.DeIn),
                getCuadro(Posicion.CeSu),
                getCuadro(Posicion.CeCe),
                getCuadro(Posicion.CeIn),
                getCuadro(Posicion.IzSu),
                getCuadro(Posicion.IzCe),
                getCuadro(Posicion.IzIn)
        ): List.of(
                getCuadro(Posicion.IzIn),
                getCuadro(Posicion.IzCe),
                getCuadro(Posicion.IzSu),
                getCuadro(Posicion.CeIn),
                getCuadro(Posicion.CeCe),
                getCuadro(Posicion.CeSu),
                getCuadro(Posicion.DeIn),
                getCuadro(Posicion.DeCe),
                getCuadro(Posicion.DeSu)

        );


        //rotan las marcas de las máquinas
        cuadros.forEach(cuadro -> cuadro.rotar(sentido));

    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (Cuadro cuadro : cuadros) {
            if (count % 3 == 0) {
                // Agregar '|' al inicio de cada fila
                sb.append("|");
            }

            // Añadir el cuadro seguido de '|'
            sb.append(cuadro).append("|");
            count++;

            // Agregar salto de línea después de cada 3 cuadros
            if (count % 3 == 0) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}