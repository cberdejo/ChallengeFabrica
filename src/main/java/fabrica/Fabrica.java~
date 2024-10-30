package fabrica;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    private List<Maquina> maquinas;

    public Fabrica() {
        maquinas = new ArrayList<>();
    }

    public static Fabrica aleatorio(int n){

    }

    public void marca(Pieza pieza){
        maquinas.forEach(maquina -> maquina.actua(pieza));
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void addMaquina(Maquina maquina){
        maquinas.add(maquina);
    }
}
