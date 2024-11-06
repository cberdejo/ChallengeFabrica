package fabrica;

public class Rotadora implements Maquina{
    private Sentido sentido;

    public Rotadora(Sentido sentido) {
        this.sentido = sentido;
    }

    public Sentido getSentido() {
        return sentido;
    }

    @Override
    public void actua(Pieza pieza) {
        pieza.rotar(sentido);
    }
}
