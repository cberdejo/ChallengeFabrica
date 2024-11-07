package fabrica;


import java.util.Map;

public class Pieza {
    private int posOrigen; //Posicion del origen de coordenadas (posicion [0,0] de la matriz)
    private static Map<Posicion, Integer> posicionMap = Map.of(
            Posicion.IzSu, 0,
            Posicion.CeSu, 1,
            Posicion.DeSu, 2,
            Posicion.DeCe, 3,
            Posicion.DeIn, 4,
            Posicion.CeIn, 5,
            Posicion.IzIn, 6,
            Posicion.IzCe, 7,
            Posicion.CeCe, 8
    );
    public Cuadro[] cuadros;

    public Pieza() {
        posOrigen = 0;
        cuadros = new Cuadro[9];
        for (int i = 0; i < 9; i++) {
            cuadros[i] = new Cuadro();
        }
    }

    public Cuadro getCuadro(Posicion posicion) {
        switch (posicion){
            case IzSu:return cuadros[posOrigen];
            case CeSu:return cuadros[posOrigen+1];
            case DeSu:return cuadros[posOrigen+2];
            case DeCe:return cuadros[posOrigen+3];
            case DeIn:return cuadros[posOrigen+4];
            case CeIn:return cuadros[posOrigen+5];
            case IzIn:return cuadros[posOrigen+6];
            case IzCe:return cuadros[posOrigen+7];
            case CeCe:return cuadros[posOrigen+8];

        }
        return null;
    }

    public void rotar(Sentido sentido) {
        if (sentido == Sentido.Horario){
            posOrigen = posOrigen -2;
            if (posOrigen <0){
                posOrigen = posOrigen + 8;
            }
        }
        else {
            posOrigen = posOrigen +2;
            if (posOrigen >7){
                posOrigen = posOrigen - 8;
            }
        }
        rotaCuadros(sentido);
    }

    public void rotaCuadros(Sentido sentido) {
        for (int i = 0; i < cuadros.length; i++) {
            cuadros[i].rotar(sentido);
        }
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