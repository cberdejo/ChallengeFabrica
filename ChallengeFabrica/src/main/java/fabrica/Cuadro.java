package fabrica;

import java.util.List;
import java.util.Map;
/// Clase que representa un cuadro de una pieza
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

    ///Comprueba si el valor del grosor es correcto, es decir que esté comprendido entre el 0 y el 3
    /// @param grosor grosor que se va a comprobar
    /// @throws IllegalArgumentException
    private void checkCorrectGrosor(int grosor){
        if (grosor < 0 || grosor >3){
            throw new IllegalArgumentException("Grosor incorrecto, debe ser entre 0 y 3");
        }
    }

    public int getGrosorFresadoraVertical() {
        return grosorFresadoraVertical;
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

    ///Rota la orientación de las marcas dado un sentido
    /// @param sentido sentido en el que se rotan las piezas
    protected void rotar(Sentido sentido){

        int grosorAux = 0;
        //Lijadora
        if (sentido == Sentido.Horario){
            grosorAux = grosorLijaNorte;
            grosorLijaNorte = grosorLijaOeste;
            grosorLijaOeste = grosorLijaSur;
            grosorLijaSur = grosorLijaEste;
            grosorLijaEste = grosorAux;

        }
        else {
            grosorAux = grosorLijaNorte;
            grosorLijaNorte = grosorLijaEste;
            grosorLijaEste = grosorLijaSur;
            grosorLijaSur = grosorLijaOeste;
            grosorLijaOeste = grosorAux;
        }

        //Fresadora (no importa la orientación para la rotación)
        grosorAux = grosorFresadoraVertical;
        grosorFresadoraVertical = grosorFresadoraHorizontal;
        grosorFresadoraHorizontal = grosorAux;

        grosorAux = grosorFresadoraDiagonalDerecha;
        grosorFresadoraDiagonalDerecha = grosorFresadoraDiagonalIzquierda;
        grosorFresadoraDiagonalIzquierda = grosorAux;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String empty = "   ";
        // Añadimos cada valor si es distinto de 0
        if (grosorLijaNorte != 0) result.append("LN").append(Integer.toString(grosorLijaNorte));
        else result.append(empty);
        if (grosorLijaEste != 0) result.append("LE").append(Integer.toString(grosorLijaEste));
        else result.append(empty);

        if (grosorLijaSur != 0) result.append("LS").append(Integer.toString(grosorLijaSur));
        else result.append(empty);

        if (grosorLijaOeste != 0) result.append("LO").append(Integer.toString(grosorLijaOeste));
        else result.append(empty);

        if (grosorFresadoraVertical != 0) result.append("FV").append(Integer.toString(grosorFresadoraVertical));
        else result.append(empty);

        if (grosorFresadoraHorizontal != 0) result.append("FH").append(Integer.toString(grosorFresadoraHorizontal));
        else result.append(empty);

        if (grosorFresadoraDiagonalIzquierda != 0) result.append("FI").append(Integer.toString(grosorFresadoraDiagonalIzquierda));
        else result.append(empty);

        if (grosorFresadoraDiagonalDerecha != 0) result.append("FD").append(Integer.toString(grosorFresadoraDiagonalDerecha));
        else result.append(empty);

        if (grosorTaladradora != 0) result.append("TL").append(Integer.toString(grosorTaladradora));
        else result.append(empty);


        return result.toString();
    }



}
