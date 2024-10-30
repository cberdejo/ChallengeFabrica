package fabrica;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pieza {
    private static Map<Posicion,Integer> posicionMap = Map.of(
            Posicion.IzSu,0,
            Posicion.CeSu,1,
            Posicion.DeSu,2,
            Posicion.IzCe,3,
            Posicion.CeCe,4,
            Posicion.DeCe,5,
            Posicion.IzIn,6,
            Posicion.CeIn,7,
            Posicion.DeIn,8
    );
    private List<Cuadro> cuadros;
    public Pieza (){
        //To Do

    }
    public Cuadro getCuadro(Posicion posicion) {
        return cuadros.get(posicionMap.get(posicion));
    }

    public void rotar(Sentido sentido){
        //To Do
        //mod 8

        //rotar cuadros por dentro
        cuadros.forEach(cuadro -> cuadro.rotar(sentido));
    }
}
