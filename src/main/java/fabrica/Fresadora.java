package fabrica;

public class Fresadora implements Maquina {

    private Grosor grosor;
    private OrFresa orFresa;
    private Posicion pos;

    public Fresadora(Grosor grosor, OrFresa orFresa, Posicion pos) {
        this.grosor = grosor;
        this.orFresa = orFresa;
        this.pos = pos;
    }

    @Override
    public void actua(Pieza pieza) {
    }
}
