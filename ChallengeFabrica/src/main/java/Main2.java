import fabrica.*;

public class Main2 {
    public static void main(String[] args) {

        /// Se declara y se inicializa la fabrica
        Fabrica fabrica = new Fabrica();

        /// Se añaden las maquinas a la fabrica
        fabrica.addMaquina(new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzCe));
        fabrica.addMaquina(new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzIn));
        fabrica.addMaquina(new Fresadora(Grosor.Grueso, OrFresa.Diagonal, Posicion.IzIn));
        fabrica.addMaquina(new Taladradora(Posicion.IzCe,Grosor.Medio));
        fabrica.addMaquina(new Taladradora(Posicion.IzIn,Grosor.Grueso));
        fabrica.addMaquina(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Medio));
        fabrica.addMaquina(new Rotadora(Sentido.Antihorario));
        fabrica.addMaquina(new Rotadora(Sentido.Antihorario));
        fabrica.addMaquina(new Lijadora(Posicion.IzCe, OrLija.Norte, Grosor.Medio));
        fabrica.addMaquina(new Rotadora(Sentido.Horario));
        fabrica.addMaquina(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Grueso));
        fabrica.addMaquina(new Taladradora(Posicion.CeCe,Grosor.Grueso));
        fabrica.addMaquina(new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzCe));
        fabrica.addMaquina(new Taladradora(Posicion.IzCe,Grosor.Fino));
        
        /// Se crea una pieza apra procesar
        Pieza pieza = new Pieza();

        /// Cada maquina actua sobre la pieza
        for (Maquina maquina : fabrica.getMaquinas()) {
            maquina.actua(pieza);
        }

        System.out.println("Representación textual de la pieza:");
        System.out.println(pieza);
    }
}
