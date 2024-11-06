package fabrica;

import java.util.List;
import java.util.Map;

public class Cuadro {
    private int grosorFresadoraVertical;
    private int grosorFresadoraHorizontal;
    private int grosorFresadoraDiagonalDerecha;
    private int grosorFresadoraDiagonalIzquierda;
    private int grosorLijaNorte;
    private int grosorLijaSur;
    private int grosorLijaEste;
    private int grosorLijaOeste;
    private int grosorTaladradora;



    public Cuadro() {
        grosorFresadoraVertical = 0;
        grosorFresadoraHorizontal = 0;
        grosorFresadoraDiagonalDerecha = 0;
        grosorFresadoraDiagonalIzquierda = 0;
        grosorLijaNorte = 0;
        grosorLijaSur =0;
        grosorLijaEste =0;
        grosorLijaOeste =0;
        grosorTaladradora=0;

    }

    public int getGrosorFresadoraVertical() {
        return grosorFresadoraVertical;
    }

    private void checkCorrectGrosor(int grosor){
        if (grosor < 0 || grosor >3){
            throw new IllegalArgumentException("Grosor incorrecto, debe ser entre 0 y 3");
        }
    }

    public void setGrosorFresadoraVertical(int grosorFresadoraVertical) {
        checkCorrectGrosor(grosorFresadoraVertical);
        this.grosorFresadoraVertical = grosorFresadoraVertical;
    }

    public int getGrosorFresadoraHorizontal() {
        return grosorFresadoraHorizontal;
    }

    public void setGrosorFresadoraHorizontal(int grosorFresadoraHorizontal) {
        checkCorrectGrosor(grosorFresadoraHorizontal);
        this.grosorFresadoraHorizontal = grosorFresadoraHorizontal;
    }

    public int getGrosorFresadoraDiagonalDerecha() {
        checkCorrectGrosor(grosorFresadoraDiagonalDerecha);
        return grosorFresadoraDiagonalDerecha;
    }

    public void setGrosorFresadoraDiagonalDerecha(int grosorFresadoraDiagonalDerecha) {
        checkCorrectGrosor(grosorFresadoraDiagonalDerecha);
        this.grosorFresadoraDiagonalDerecha = grosorFresadoraDiagonalDerecha;
    }

    public int getGrosorFresadoraDiagonalIzquierda() {
        checkCorrectGrosor(grosorFresadoraDiagonalIzquierda);
        return grosorFresadoraDiagonalIzquierda;
    }

    public void setGrosorFresadoraDiagonalIzquierda(int grosorFresadoraDiagonalIzquierda) {
        checkCorrectGrosor(grosorFresadoraDiagonalIzquierda);
        this.grosorFresadoraDiagonalIzquierda = grosorFresadoraDiagonalIzquierda;
    }

    public int getGrosorLijaNorte() {
        return grosorLijaNorte;
    }

    public void setGrosorLijaNorte(int grosorLijaNorte) {
        checkCorrectGrosor(grosorLijaNorte);
        this.grosorLijaNorte = grosorLijaNorte;
    }

    public int getGrosorLijaSur() {
        return grosorLijaSur;
    }

    public void setGrosorLijaSur(int grosorLijaSur) {
        checkCorrectGrosor(grosorLijaSur);
        this.grosorLijaSur = grosorLijaSur;
    }

    public int getGrosorLijaEste() {
        return grosorLijaEste;
    }

    public void setGrosorLijaEste(int grosorLijaEste) {
        checkCorrectGrosor(grosorLijaEste);
        this.grosorLijaEste = grosorLijaEste;
    }

    public int getGrosorLijaOeste() {
        return grosorLijaOeste;
    }

    public void setGrosorLijaOeste(int grosorLijaOeste) {
        checkCorrectGrosor(grosorLijaOeste);
        this.grosorLijaOeste = grosorLijaOeste;
    }

    public int getGrosorTaladradora() {
        return grosorTaladradora;
    }

    public void setGrosorTaladradora(int grosorTaladradora) {
        checkCorrectGrosor(grosorTaladradora);
        this.grosorTaladradora = grosorTaladradora;
    }

    ///
    protected void rotar(Sentido sentido){
        int grosorSwich = 0;
        if (sentido == Sentido.Horario){
            grosorSwich = grosorLijaNorte;
            grosorLijaNorte = grosorLijaEste;
            grosorLijaEste = grosorLijaSur;
            grosorLijaSur = grosorLijaOeste;
            grosorLijaOeste = grosorSwich;

        }
        else {
            grosorSwich = grosorLijaNorte;
            grosorLijaNorte = grosorLijaOeste;
            grosorLijaOeste = grosorLijaSur;
            grosorLijaSur = grosorLijaEste;
            grosorLijaOeste = grosorSwich;

        }
        grosorSwich = grosorFresadoraVertical;
        grosorFresadoraVertical = grosorFresadoraHorizontal;
        grosorFresadoraDiagonalDerecha = grosorSwich;

        grosorSwich = grosorFresadoraDiagonalDerecha;
        grosorFresadoraDiagonalDerecha = grosorFresadoraDiagonalIzquierda;
        grosorFresadoraDiagonalIzquierda = grosorSwich;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Añadimos cada valor si es distinto de 0
        if (grosorLijaNorte != 0) result.append("LN").append(Integer.toString(grosorLijaNorte));
        if (grosorLijaEste != 0) result.append("LE").append(Integer.toString(grosorLijaEste));
        if (grosorLijaSur != 0) result.append("LS").append(Integer.toString(grosorLijaSur));
        if (grosorLijaOeste != 0) result.append("LO").append(Integer.toString(grosorLijaOeste));
        if (grosorFresadoraVertical != 0) result.append("FV").append(Integer.toString(grosorFresadoraVertical));
        if (grosorFresadoraHorizontal != 0) result.append("FH").append(Integer.toString(grosorFresadoraHorizontal));
        if (grosorFresadoraDiagonalIzquierda != 0) result.append("FI").append(Integer.toString(grosorFresadoraDiagonalIzquierda));
        if (grosorFresadoraDiagonalDerecha != 0) result.append("FD").append(Integer.toString(grosorFresadoraDiagonalDerecha));
        if (grosorTaladradora != 0) result.append("T").append(Integer.toString(grosorTaladradora));


        return result.toString();
    }


}
