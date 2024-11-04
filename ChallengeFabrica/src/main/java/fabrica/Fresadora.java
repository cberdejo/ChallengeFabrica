package fabrica;

public class Fresadora implements Maquina {

    private Grosor grosor;
    private OrFresa orFresa;
    private Posicion pos;

    public Fresadora(Grosor grosor, OrFresa orFresa, Posicion posi) {
        this.grosor = grosor;
        this.orFresa = orFresa;
        this.pos = posi;
    }

    @Override
    public void actua(Pieza pieza) {
    }
}
