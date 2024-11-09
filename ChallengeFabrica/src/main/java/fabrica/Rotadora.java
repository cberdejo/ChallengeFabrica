package fabrica;
/// Máquina que rota una pieza en un sentido o en el contrario
public class Rotadora implements Maquina{
    private Sentido sentido;

    public Rotadora(Sentido sentido) {
        this.sentido = sentido;
    }

    public Sentido getSentido() {
        return sentido;
    }

    /// Actua sobre la pieza y la rota
    /// @param pieza La pieza sobre la que se actua
    @Override
    public void actua(Pieza pieza) {
        pieza.rotar(sentido);
    }
}
