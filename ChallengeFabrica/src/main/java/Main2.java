import fabrica.*;

public class Main2 {
    public static void main(String[] args) {

        Fabrica fabrica = new Fabrica();

        fabrica.addMaquina(new Fresadora(Grosor.Medio, OrFresa.Horizontal, Posicion.CeSu));
        fabrica.addMaquina(new Taladradora(Posicion.CeSu,Grosor.Medio));
        fabrica.addMaquina(new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzCe));
        fabrica.addMaquina(new Fresadora(Grosor.Medio, OrFresa.Diagonal, Posicion.IzIn));
        fabrica.addMaquina(new Taladradora(Posicion.IzCe,Grosor.Medio));
        fabrica.addMaquina(new Taladradora(Posicion.IzIn,Grosor.Medio));
        fabrica.addMaquina(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Medio));
        fabrica.addMaquina(new Rotadora(Sentido.Antihorario));
        fabrica.addMaquina(new Rotadora(Sentido.Antihorario));
        fabrica.addMaquina(new Lijadora(Posicion.IzCe, OrLija.Norte, Grosor.Medio));
        fabrica.addMaquina(new Rotadora(Sentido.Horario));
        fabrica.addMaquina(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Grueso));
        fabrica.addMaquina(new Taladradora(Posicion.IzIn,Grosor.Grueso));
        

        Pieza pieza = new Pieza();


        System.out.println("Representación textual de la pieza:");
        System.out.println(pieza);
    }
}
