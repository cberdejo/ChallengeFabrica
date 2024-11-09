import fabrica.*;

public class Main2 {
    public static void main(String[] args) {

        // Se declara y se inicializa la fabrica
        Fabrica fabrica = new Fabrica();

        // Se añaden las maquinas a la fabrica
        fabrica.addMaquina(new Fresadora(Posicion.IzCe,  OrFresa.Vertical, Grosor.Medio));
        fabrica.addMaquina(new Fresadora(Posicion.IzIn, OrFresa.Vertical,Grosor.Medio ));
        fabrica.addMaquina(new Fresadora( Posicion.IzIn, OrFresa.Diagonal,Grosor.Grueso));
        fabrica.addMaquina(new Taladradora(Posicion.IzCe,Grosor.Medio));
        fabrica.addMaquina(new Taladradora(Posicion.IzIn,Grosor.Grueso));
        fabrica.addMaquina(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Medio));
        fabrica.addMaquina(new Rotadora(Sentido.Antihorario));
        fabrica.addMaquina(new Rotadora(Sentido.Antihorario));
        fabrica.addMaquina(new Lijadora(Posicion.IzCe, OrLija.Norte, Grosor.Medio));
        fabrica.addMaquina(new Rotadora(Sentido.Horario));
        fabrica.addMaquina(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Grueso));
        fabrica.addMaquina(new Taladradora(Posicion.CeCe,Grosor.Grueso));
        fabrica.addMaquina(new Fresadora( Posicion.IzCe, OrFresa.Vertical,Grosor.Medio));
        fabrica.addMaquina(new Taladradora(Posicion.IzCe,Grosor.Fino));
        
        // Se crea una pieza apra procesar
        Pieza pieza = new Pieza();

        fabrica.marca(pieza);

        System.out.println("Representación textual de la pieza:");
        System.out.println(pieza);
    }
}
