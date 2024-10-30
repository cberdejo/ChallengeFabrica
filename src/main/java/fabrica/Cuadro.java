package fabrica;

import java.util.List;

public class Cuadro {
    private String fresadoraVertical;
    private String fresadoraHorizontal;
    private String fresadoraDiagonalDerecha;
    private String fresadoraDiagonalIzquierda;
    private String lijaNorte;
    private String lijaSur;
    private String lijaEste;
    private String lijaOeste;
    private String taladradora;

    public Cuadro() {
        fresadoraVertical = "   ";
        fresadoraHorizontal = "   ";
        fresadoraDiagonalDerecha = "   ";
        fresadoraDiagonalIzquierda = "   ";
        lijaNorte = "   ";
        lijaSur = "   ";
        lijaEste = "   ";
        lijaOeste = "   ";
        taladradora = "   ";

    }

    protected String getFresadoraVertical() {
        return fresadoraVertical;
    }
    protected void setFresadoraVertical(String fresadoraVertical) {
        this.fresadoraVertical = fresadoraVertical;
    }

    protected String getFresadoraHorizontal() {
        return fresadoraHorizontal;
    }
    protected void setFresadoraHorizontal(String fresadoraHorizontal) {
        this.fresadoraHorizontal = fresadoraHorizontal;
    }

    protected String getFresadoraDiagonalDerecha() {
        return fresadoraDiagonalDerecha;
    }
    protected void setFresadoraDiagonalDerecha(String fresadoraDiagonalDerecha) {
        this.fresadoraDiagonalDerecha = fresadoraDiagonalDerecha;
    }

    protected String getFresadoraDiagonalIzquierda() {
        return fresadoraDiagonalIzquierda;
    }
    protected void setFresadoraDiagonalIzquierda(String fresadoraDiagonalIzquierda) {
        this.fresadoraDiagonalIzquierda = fresadoraDiagonalIzquierda;
    }

    protected String getLijaNorte() {
        return lijaNorte;
    }
    protected void setLijaNorte(String lijaNorte) {
        this.lijaNorte = lijaNorte;
    }

    protected String getLijaSur() {
        return lijaSur;
    }
    protected void setLijaSur(String lijaSur) {
        this.lijaSur = lijaSur;
    }

    protected String getLijaEste() {
        return lijaEste;
    }
    protected void setLijaEste(String lijaEste) {
        this.lijaEste = lijaEste;
    }

    protected String getLijaOeste() {
        return lijaOeste;
    }
    protected void setLijaOeste(String lijaOeste) {
        this.lijaOeste = lijaOeste;
    }

    protected List<String> getLijas(){
        return List.of(lijaNorte, lijaSur, lijaEste, lijaOeste);
    }

    protected String getTaladradora() {
        return taladradora;
    }



    public void setTaladradora(String taladradora) {
        this.taladradora = taladradora;
    }
    @Override
    public String toString() {
        return "|" + lijaNorte + lijaEste + lijaSur + lijaOeste +
                fresadoraVertical + fresadoraHorizontal + fresadoraDiagonalIzquierda + fresadoraDiagonalDerecha +
                taladradora +
                "|";
    }
}
